/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

/*
Solution: keep two arrays to store max and min product, also consider if the current number is positive or negative:
if nums[i]>0 : max[i]=Math.max(nums[i], max[i-1]*nums[i])
               min[i]=Math.min(nums[i], min[i-1]*nums[i])
if nums[i]<0 : max[i]=Math.max(nums[i], min[i-1]*nums[i])
               min[i]=Math.min(nums[i], max[i-1]*nums[i])
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int[] max=new int[nums.length];
        int[] min=new int[nums.length];
        max[0]=min[0]=nums[0];
        int max_product=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0){
                max[i]=Math.max(nums[i],max[i-1]*nums[i]);
                min[i]=Math.min(nums[i],min[i-1]*nums[i]);
            }
            else if(nums[i]<0){
                max[i]=Math.max(nums[i],min[i-1]*nums[i]);
                min[i]=Math.min(nums[i],max[i-1]*nums[i]);
            }
            max_product=Math.max(max_product,max[i]);
        }
        return max_product;
        
        
    }
}

