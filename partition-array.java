/*Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

 Notice

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length
*/

/*runtime:O(N)
space:O(1)
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums==null||nums.length==0) return 0;
	    int left=0, right= nums.length-1;
	    while(left<=right){
	        if(nums[left]>=k){
	            int tmp=nums[left];
	            nums[left]=nums[right];
	            nums[right]=tmp;
	            right--;
	        }
	        else{
	            left++; 
	        }
	    }
	    
	    return left;
    }
}
