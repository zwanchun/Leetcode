/*Search in Rotated Sorted Array II
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0) return false;
        int start=0, end=nums.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]==nums[start]) start++;
            else if(nums[mid]>nums[start]){
                if(target<nums[mid]&&nums[start]<=target) end=mid;
                else start=mid;
            }
            else{
                if(nums[mid]<target&&target<=nums[end]) start=mid;
                else end=mid;
                
            }
            
        }
        if(nums[start]==target||nums[end]==target) return true;
        else return false;
        
    }
}
