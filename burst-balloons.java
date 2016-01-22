/* Burst Balloons
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
   */
   
   /*solution: http://bookshadow.com/weblog/2015/11/30/leetcode-burst-balloons/
   */
   
   public class Solution {
    public int maxCoins(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length+2;
        int[] extnums=new int[n];
        extnums[0]=extnums[n-1]=1;
        for(int i=0;i<nums.length;i++){
            extnums[i+1]=nums[i];
        }
        
        int[][] dp=new int[n][n];
        
        for(int k=2;k<n;k++){
            for(int left=0;left<n-k;left++){
                int right=left+k;
                for(int i=left+1;i<right;i++){
                    dp[left][right]=Math.max(dp[left][right],extnums[left]*extnums[i]*extnums[right]+dp[left][i]+dp[i][right]);
                }
                
            }
        }
        return dp[0][n-1];
        
    }
}
