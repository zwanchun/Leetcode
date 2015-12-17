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
