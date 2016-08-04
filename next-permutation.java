/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

/*solution:
从序列的后端逆序比较，比如 1 ，2， 3 的下一个序列是  1， 3 ，2  ，这样只需交换 2,3即可。
对于序列1, 2, 5, 4, 3：逆序寻找到2 ， 5，发现这两个元素是顺序的，则从尾部逆序寻找一个比2 大的数，这里是3，和2 交换位置，变成1 ，3 ，5 ，4 ，2 
最后再，反转5， 4， 2 即可得到下一个序列： 1 ，3 ，2， 4， 5 */

public class Solution {
      public void nextPermutation(int[] nums) {
        
        if(nums==null||nums.length<=1) return;
        
        int start_point=-1;
        
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                start_point=i+1;
                for(int j=nums.length-1;j>=start_point;j--){
                	if(nums[j]>nums[i]){
                		int temp=nums[i];
                		nums[i]=nums[j];
                		nums[j]=temp;
                		break;
                	}
                }
                break;
            }
            
        }
        
        if(start_point==-1) Arrays.sort(nums);
        else{
            for(int i=start_point+1;i<nums.length;i++){
                int temp=nums[i];
                int j=i;
                for(;j>start_point && temp<nums[j-1];j--){
                    nums[j]=nums[j-1];
                }
                nums[j]=temp;
            }
        }
    }
}
