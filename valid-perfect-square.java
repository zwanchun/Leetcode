/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
*/

/* solution 1 : using binary search
runtime complexity: O(logN)
space complexity: O(N)
*/

public class Solution {
    public boolean isPerfectSquare(int num) {
        
        if(num==1) return true;
        
        long nums=(long)num;
        
        long left=1,
        right=nums/2,
        mid=0;
        
        while(left+1<right){
            mid=left+(right-left)/2;
            if(mid*mid==nums) return true;
            else if(mid*mid<nums) left=mid+1;
            else right=mid-1;
        }
        
        if(left*left==nums||right*right==nums) return true;
        
        return false;
        
        
        
    }
}
