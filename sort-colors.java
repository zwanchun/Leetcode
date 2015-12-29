/*Sort Colors
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

*/

/* solution:
这种方法的时间复杂度是O(2*n)，空间是O(k)，k是颜色的数量，这里是3。
上述方法需要两次扫描，我们考虑怎么用一次扫描来解决。其实还是利用了颜色是三种这一点，道理其实也简单，就是搞两个指针，一个指在当前0的最后一个下标，另一个是指在当前1的最后一个下标（2不需要指针因为剩下的都是2了）。进行一次扫描，如果遇到0就两个指针都前进一步并进行赋值，如果遇到1就后一个指针前进一步并赋值。
*/

public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length<=1) return;
        int idx0=0;
        int idx1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=2;
                nums[idx1++]=1;
                nums[idx0++]=0;
            }
            else if(nums[i]==1){
                nums[i]=2;
                nums[idx1++]=1;
            }
        }
        
    }
}
