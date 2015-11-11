/*Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

/*问题的本质是求斐波那契数列（Fibonacci Sequence）
递推式为：dp[x] = dp[x - 1] + dp[x - 2]
从x-2到x走两步，从x-1到x走一步，所以x的所有解法等于x-1与x-2解法的总和
*/

public class Solution {
    public int climbStairs(int n) {
        
        if(n<=0) return 0;
        if(n<=2) return n;
        int[] solutions=new int[n];
        solutions[0]=1;
        solutions[1]=2;
        for(int i=2;i<n;i++){
            solutions[i]=solutions[i-1]+solutions[i-2];
        }
        return solutions[n-1];
        
    }
}
