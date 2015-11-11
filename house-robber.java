/* House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

/*
动态规划（Dynamic Programming）
状态转移方程：
dp[i] = max(dp[i - 1], dp[i - 2] + num[i - 1])
其中，dp[i]表示打劫到第i间房屋时累计取得的金钱最大值。
时间复杂度O(n)，空间复杂度O(n)
*/


public class Solution {
    public int rob(int[] nums) {
       
        
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        
        int[] maxmon=new int[nums.length];
        maxmon[0]=nums[0];
        maxmon[1]=Math.max(nums[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
            maxmon[i]=Math.max(maxmon[i-1],maxmon[i-2]+nums[i]);
        }
        
        return maxmon[nums.length-1];
        
   
    }
}
