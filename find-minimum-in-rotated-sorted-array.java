/*Find Minimum in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int left=0, right=nums.length-1;
        int target=nums[right];
        //find the first element less than target
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target) left=mid+1;
            else right=mid-1;
        }
        return nums[left];
    }
}
