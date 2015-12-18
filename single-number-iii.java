/*Single Number III
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

/* solution:
关于single number的解法，因为只有一个未知数，比较直观：http://fisherlei.blogspot.com/2013/11/leetcode-single-number-solution.html。

这题有两个未知数，直接做异或肯定是不行的，那么如何通过一些变换把这道题分解开，使得可以应用Single Number的解法来做，才是这个题目有意思的地方。
首先，对于数组A, 假设存在b，c两个数字，在数组中只出现了一次，那么对于整个数组进行异或操作的话，
^[A]   =  b^c ,  因为其他的数因为出现了两次，异或的过程中就被清零了。

但是仅仅通过最后异或出来的值，是没办法求出b和c的值的，但是足以帮我们把b和c划分到不同的子数组中去。

一个整数有32位bit，对于b和c，除非两者是相同的数，否则一定存在第K位bit，两者是不同的。看下面的例子，

当找到这个K以后，就可以按照第K位bit是否等于1，将A数组划分成两个子数组，而这两个子数组分别包含了b和c，那么剩下的就只需要把single number的算法直接应用到这两个子数组上，就可以得到b和c了。
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums==null||nums.length<2) return null;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        int lastbit=xor-(xor&(xor-1));
        int group0=0, group1=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&lastbit)==0){
                group0^=nums[i];
            }
            else group1^=nums[i];
        }
        int[] result={group0,group1};
        return result;
        
    }
}
