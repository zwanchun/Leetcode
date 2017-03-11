/*Find Peak Element
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
*/

/*solution: http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
首先我们找到中间节点mid，如果大于两边返回当前index就可以了，如果左边的节点比mid大，那么我们可以继续在左半区间查找，这里面一定存在一个peak，为什么这么说呢？假设此时的区间范围为[0, mid - 1]， 因为num[mid - 1]一定大于num[mid]了，如果num[mid - 2] <= num[mid - 1]，那么num[mid - 1]就是一个peak。如果num[mid - 2] > num[mid - 1]，那么我们就继续在[0, mid - 2]区间查找，因为num[-1]为负无穷，所以最终我们绝对能在左半区间找到一个peak。同理右半区间一样。
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null) return -1;
        if(nums.length==0) return 0;
        int start=0, end=nums.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(((mid==0)&&(nums[mid]>nums[mid+1]))||((mid==nums.length-1)&&(nums[mid]>nums[mid-1]))){
                return mid;
            }
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]<nums[mid-1]){
                end=mid-1;
            }
            else start=mid+1;
        }
        if(nums[start]>nums[end]) return start;
        else return end;
        
        
    }
}

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A==null||A.length==0) return -1;
        int start=0,end=A.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(mid==0||mid==A.length-1) return -1;
            if(A[mid]>A[mid-1]&&A[mid]>A[mid+1]) return mid;
            else if(A[mid]<A[mid+1]) start=mid;
            else end=mid;
        }
        
        if(A[start]>A[start-1]&&A[start]>A[start+1]) return start;
        else return end;
    }
}

