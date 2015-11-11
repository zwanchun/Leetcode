/*House Robber II
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

/* If the first house being robbed, then the last one cannot be robbed, therefore return the second to last's max value
If the first house is not robbed, then the last one can be robbed, return the last one's max value
then return the max of two max values*/

public class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        
        int[] maxmon=new int[nums.length];
        maxmon[0]=0;
        maxmon[1]=nums[1];
        
        for(int i=2;i<nums.length;i++){
            maxmon[i]=Math.max(maxmon[i-1],maxmon[i-2]+nums[i]);
        }
        
        int max1=maxmon[nums.length-1];
        
        maxmon[0]=nums[0];
        maxmon[1]=Math.max(nums[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
            maxmon[i]=Math.max(maxmon[i-1],maxmon[i-2]+nums[i]);
        }
        
        int max2=maxmon[nums.length-2];
        
        return Math.max(max1,max2);
        
    }
    
}
