/*Ugly Number II
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/

/*solution:
http://www.geeksforgeeks.org/ugly-numbers/
*/

public class Solution {
    public int nthUglyNumber(int n) {
       if(n==0) return -1;
       int[] unums=new int[n];
       unums[0]=1;
       int i2=0, i3=0, i5=0;
       for(int i=1;i<n;i++){
           unums[i]=Math.min(Math.min(unums[i2]*2,unums[i3]*3),Math.min(unums[i3]*3,unums[i5]*5));
           if(unums[i2]*2==unums[i]) i2++;
           if(unums[i3]*3==unums[i]) i3++;
           if(unums[i5]*5==unums[i]) i5++;
       }
       return unums[n-1];
    }
}
