/*Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

/*solution:
实现的思路是基于数组的元素是整数，我们通过统计整数的每一位来得到出现次数。我们知道如果每个元素重复出现三次，那么每一位出现1的次数也会是3的倍数，如果我们统计完对每一位进行取余3，那么结果中就只剩下那个出现一次的元素。总体只需要对数组进行一次线性扫描，统计完之后每一位进行取余3并且将位数字赋给结果整数，这是一个常量操作（因为整数的位数是固定32位），所以时间复杂度是O(n)。而空间复杂度需要一个32个元素的数组，也是固定的，因而空间复杂度是O(1)。
*/

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int result=0;
        int[] bits=new int[32];
        for(int i=0;i<32;i++){
            for(int j=0;j<nums.length;j++){
                bits[i] += nums[j] >> i & 1;
                bits[i] %= 3;
            }
            result |= (bits[i] << i);
        }
        return result;
        
        
    }
}
