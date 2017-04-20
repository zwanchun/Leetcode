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


/*
可以找到感觉，发现找到next permutation的规律是有三步
从右往左找到第一个非递增的数 s[i] < s[i+1]
如果找到头依然没有，说明已经最大，next permutation就是reverse得到最小的数
从i的右边，找到比s[i]大的最小值，因为右边是从右往左递增的，所以找法就是s[j] > s[i] >= s[1], swap s[i] 和s[j]
现在要得到右边最小的数，就将i右边的数字递增排序，注意python的语法s[i+1:lengh] = s[length-1:i:-1]
*/
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: An array of integers that's next permuation
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if(nums==null||nums.length<=1) return nums;
        int start_index=-1;
        
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                start_index=i;
                for(int j=nums.length-1;j>=start_index;j--){
                    if(nums[j]>nums[i-1]){
                        int temp=nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=temp;
                        break;
                    }
                }
                break;
            }
             
        }
        
        if(start_index==-1){
            Arrays.sort(nums);
        }
        else{
            for(int i=start_index,j=nums.length-1;i<j;i++,j--){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        
        return nums;
        
         
        
    }
}

