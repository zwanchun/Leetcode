/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/

/*http://www.cnblogs.com/yuzhangcmu/p/4189068.html

runtime: O(N^2)

这个方法其实很直观，就是从头扫描到尾部，每一个字符以它为中心向2边扩展，扩展到不能扩展为止（有不同的字符），返回以每一个字符为中心的回文，然后不断更新最大回文并返回之。

算法简单，而且复杂度为O(n^2),空间复杂度为O(1)

*/

public class Solution {
    public String longestPalindrome(String s) {
        
        if(s==null||s.length()==0) return s;
        int max=0;
        String rst=null;
        
        for(int i=0;i<s.length();i++){
            String s1=getLongest(s,i,i);
            String s2=getLongest(s,i,i+1);
            
            if(s1.length()>max){
                max=s1.length();
                rst=s1;
            }
            
            if(s2.length()>max){
                max=s2.length();
                rst=s2;
            }
        
            
        }
        
        return rst;
        
        
    }
    
    private String getLongest(String s, int left, int right){
        while(left>=0&&right<s.length()){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        
        return s.substring(left+1,right);
    }
}
