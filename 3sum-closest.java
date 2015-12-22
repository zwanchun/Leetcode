/*3Sum Closest
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3) return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE / 2;// otherwise it will overflow for opeartion (closet-target)
        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target) return sum;
                else if(sum<target) left++;
                else right--;
                closest=Math.abs(sum-target)<Math.abs(closest-target)?sum:closest;
                
            }
            
        }
        return closest;
        
    }
}
