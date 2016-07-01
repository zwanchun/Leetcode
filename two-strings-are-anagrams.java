/* time: O(n)
space:O(1)
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if(s==null||t==null) return false;
        if(s.length()!=t.length()) return false;
        if(s.length()==0&&t.length()==0) return true;
        
        int[] count=new int[256];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        for(int i=0;i<t.length();i++){
            if(count[t.charAt(i)]==0) return false;
            else count[t.charAt(i)]--;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
};
