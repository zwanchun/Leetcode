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


public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums==null||nums.length==0) return Integer.MIN_VALUE;
        int start=0, end=nums.length-1;
        int pivot=nums[0];
        if(pivot<=nums[nums.length-1]) return pivot;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(nums[mid]>=pivot) start=mid;
            else end=mid;
        }
        
        if(nums[start]<nums[end]) return nums[start];
        else return nums[end];
    }
}
