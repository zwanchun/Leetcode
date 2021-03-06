/*Search in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

/*solutions: http://fisherlei.blogspot.com/2013/01/leetcode-search-in-rotated-sorted-array.html*/

public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int start=0, end=nums.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>nums[start]){
                if(target>=nums[start]&&target<nums[mid]) end=mid;
                else start=mid;
            }
            else{
                if(nums[mid]<target&&target<=nums[end]) start=mid;
                else end=mid;
            }
        }
        if(nums[start]==target) return start;
        else if(nums[end]==target) return end;
        else return -1;
    }
}


public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A==null||A.length==0) return -1;
        int start=0,end=A.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(A[mid]==target) return mid;
            if(A[mid]>A[start]){
                if(target>=A[start]&&A[mid]>=target){
                    end=mid;
                }
                else{
                    start=mid;
                }
            }
            else{
                if(target>=A[mid]&&target<=A[end]){
                    start=mid;
                }
                else{
                    end=mid;
                }
            }
        }
        if(A[start]==target) return start;
        if(A[end]==target) return end;
        return -1;
    }
}

