/*Single Number
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

/* Bit manipulation:
x^x=0
0^x=x
*/

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int rst=0;
        for(int i=0;i<nums.length;i++){
            rst^=nums[i];
        }
        return rst;
        
    }
}
