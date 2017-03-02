/*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

/*http://blog.csdn.net/linhuanmars/article/details/19949159
when there are duplicate characters, jump to the place behind the first duplicate letter
runtime: O(N)
space: O(N)
*/


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        Set<Character> set=new HashSet<Character>();
        int left=0, max=0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                while(left<i && s.charAt(left)!=s.charAt(i)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            else{
                set.add(s.charAt(i));
                max=Math.max(max,i-left+1);
            }
        }
        return max;
    }
}


/*http://www.cnblogs.com/yuzhangcmu/p/4188973.html*/
/*O(N)*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int max_length=0;
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        int left=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))>=left){
                left=map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i),i);
            max_length=Math.max(max_length,i-left+1);
        }
        
        return max_length;
        
    }
}

