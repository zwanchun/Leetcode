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


/*search left bound, search right bound*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
      
        if(A==null||A.length==0) return new int[]{-1,-1};
        
        int[] rst=new int[2];
        
        int start=0,end=A.length-1;
        int mid=0;
        while(start+1<end){
            mid=start+(end-start)/2;
            if(A[mid]==target) break;
            else if(A[mid]>target) end=mid;
            else start=mid;
        }
        if(A[start]!=target&&A[end]!=target&&A[mid]!=target) return new int[]{-1,-1};
        int end1=0,start2=0;
        if(A[mid]==target){
            end1=start2=mid;
        }
        else if(A[start]==target){
            end1=start2=start;
        }
        else end1=start2=end;
        start=0;
        end=A.length-1;
        while(start+1<end1){
            int mid1=start+(end1-start)/2;
            if(A[mid1]>=target) end1=mid1;
            else start=mid1;
        }
        if(A[start]==target) rst[0]=start;
        else rst[0]=end1;
        while(start2+1<end){
            int mid2=start2+(end-start2)/2;
            if(A[mid2]<=target) start2=mid2;
            else end=mid2;
        }
        if(A[end]==target) rst[1]=end;
        else rst[1]=start2;
        return rst;
        
    }
}
