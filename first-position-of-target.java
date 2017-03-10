/*For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

challenge:If the count of numbers is bigger than 2^32, can your code work properly?
*/

/*runtime:O(logN)
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums==null||nums.length==0) return -1;
        int start=0, end=nums.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(nums[mid]>=target) end=mid;
            else start=mid;
        }
        
        if(nums[start]==target) return start;
        if(nums[end]==target) return end;
        return -1;
    }
}
