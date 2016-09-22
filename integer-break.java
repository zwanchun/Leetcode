/*Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

Hint:

There is a simple O(n) solution to this problem.
You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
*/

/*http://bookshadow.com/weblog/2016/04/19/leetcode-integer-break/
solution 1:
n / 3 <= 1 时，分为两个数的乘积，尽量均摊
n / 3 > 1 时，分为若干个3和2的乘积
n % 3 == 0 时，分为n个3的乘积
n % 3 == 1 时，分为n-1个3和两个2的乘积
n % 3 == 2 时，分为n个3和一个2的乘积

solution2:
dp[i]表示整数i拆分可以得到的最大乘积，则dp[i]只与dp[i - 2], dp[i - 3]两个状态有关

得到状态转移方程：

dp[x] = max(3 * dp[x - 3], 2 * dp[x - 2])
当x <= 3时，需要对结果进行特判。
*/

public class Solution {
    public int integerBreak(int n) {
        if(n<=3) return n-1;
        int[] dp=new int[n+1];
        for(int i=1;i<=3;i++){
            dp[i]=i;
        }
        
        for(int i=4;i<=n;i++){
            dp[i]=Math.max(3*dp[i-3],2*dp[i-2]);
        }
        return dp[n];
    }
}
