/*Find Minimum in Rotated Sorted Array II
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

/*solutions: http://blog.csdn.net/linhuanmars/article/details/40449299*/

/*由于此题输入可能有重复元素，因此在num[mid] == num[end]时无法使用二分的方法缩小start或者end的取值范围。此时只能使用递增start/递减end逐步缩小范围。*/

public class Solution {
    public int findMin(int[] nums) {
       if(nums == null || nums.length==0)  return 0;  
       int start = 0, end=nums.length-1;  
       int min = nums[0];  
       while(start+1<end){  
           int mid = start+(end-start)/2;  
           if(nums[start]<nums[mid]){
               min=Math.min(nums[start],min);
               start=mid;
           }
           else if(nums[start]>nums[mid]){
               min=Math.min(nums[mid],min);
               end=mid;
           }
           else{
               start++;
           }
       
        }  
        min = Math.min(nums[start],min);  
        min = Math.min(nums[end],min);  
        return min;  
        
    }
    
    
    
    public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num==null||num.length==0) return -1;
        if(num[0]<num[num.length-1]) return num[0];
        int start=0, end=num.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(num[mid]>num[end]){
                start=mid;
            }
            else if(num[mid]<num[end]){
                end=mid;
            }
            else{
               end--;
            }
        }
        
        if(num[start]<num[end]) return num[start];
        return num[end];
    }
}
}
