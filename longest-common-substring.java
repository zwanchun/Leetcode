/*Given two strings, find the longest common substring.

Return the length of it.

 Notice

The characters in substring should occur continuously in original string. This is different with subsequence.

Have you met this question in a real interview? Yes
Example
Given A = "ABCD", B = "CBCE", return 2.*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A==null||B==null||A.length()==0||B.length()==0) return 0;
        if(A.length()<B.length()){
            String tmp=A;
            A=B;
            B=tmp;
        }
        for(int i=B.length();i>0;i--){
            for(int j=0;j+i<=B.length();j++){
                String sub=B.substring(j,j+i);
                if(A.indexOf(sub)!=-1) return i;
            }
            
        }
        return 0;
    }
}


/* other solutions:
http://www.code123.cc/docs/leetcode-notes/string/longest_common_substring.html
https://lefttree.gitbooks.io/leetcode/content/dynamicProgramming2/longestCommonSubstring.html
*/
