/*Decode Ways
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

/*solution:
解题思路：

动态规划. dp[i] 表示 s[0:i-1]的结果.

若当前字符s[i-1]为0
若前面的字符是1或2, 则这1或2必须得跟0结合, dp[i] = dp[i-2] eg: XXX(10)
若前面的字符不是1或者2, 拼接不起来了，直接return 0.
当前字符不为0
前面的字符为1 或者 2且当前字符为1-6. 即可分两种情况拆分, dp[i] = dp[i-2] + dp[i-1], eg: XXX16: (XXX)(16) + (XXX1)6
其他, 只能自己跟自己一组了. dp[i] = dp[i-1] eg: (XXX3)6
还可以将下面的O(n)空间化简成常数空间～记录之前上一次结果 和 上上一次的结果，当前的结果由此获得。
*/

public class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.equals("0")) return 0;
        int[] dp=new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9') return 0;
            if(s.charAt(i)=='0'){
                if(i==0||s.charAt(i-1)=='0'||s.charAt(i-1)>'2') return 0;
                dp[i]=(i==1)?1:dp[i-2];
            }
            else{
                if(i>0&&(s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)<='6'))){
                    dp[i]=dp[i-1]+((i==1)?1:dp[i-2]);
                }
                else{
                    dp[i]=(i>0)?dp[i-1]:1;
                }
    
            }
        }
        return dp[s.length()-1];
        
        
        
    }
}
