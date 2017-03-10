/*Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

/* Solution: using binary search*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0) return 0;
        int imin=0, imax=nums.length-1;
        int imid=0;
        while(imin<=imax){
            imid=imin+(imax-imin)/2;
            if(nums[imid]==target) return imid;
            else if(nums[imid]<target) imin=imid+1;
            else imax=imid-1;
        }
        if(nums[imid]<target) return imid+1;
        else return imid;
        
    }
}


public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A==null||A.length==0) return 0;
        int start=0, end=A.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(A[mid]==target) return mid;
            else if(A[mid]<target) start=mid;
            else end=mid;
        }
        
        if(A[start]<target&&A[end]>=target) return end;
        else if(A[start]>=target) return start;
        else return end+1;
    }
}
