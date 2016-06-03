//Mine Solution

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        if(nums==null||nums.length==0||nums.length==1) return;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0||nums[i-1]!=0) continue;
            int j=i-1;
            while(nums[j]==0&&j>0) j--;
            if(j!=0||(j==0&&nums[j]!=0)) j=j+1;
            int temp=nums[i];
            nums[i]=0;
            nums[j]=temp;
            
        }
        
        return;
    }
}

//Reference: https://segmentfault.com/a/1190000003768716
