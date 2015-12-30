/*Search for a Range
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[]{-1, -1};
        int left,right,mid;
        int[] range=new int[2];
        
        left=0;
        right=nums.length-1;
        
        //search left bound
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            
        }
        if(left<nums.length&&nums[left]==target){
            range[0]=left;
        }
        else{
            return new int[]{-1, -1};
        }
        
        left=0;
        right=nums.length-1;
        
        //search right bound
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]<=target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        range[1]=right;
        return range;
    }
        
        
}
