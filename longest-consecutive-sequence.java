/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

/*对于每一个n，可以检查n-1, n+1是否存在于这个set（或者map）中；对于map的每个操作都是O(1)的，所以最终是O(n);
对于每一个n，检查是否为一个consecutive sequence的边界，也就是n-1不存在于set中，再逐次检查n + 1, n + 2, n + 3...是否在set中，
最终得到另一个上边界（+1）m，所以sequence的长度为m - n （也可以是n+1不存在于set中，则反向检查）。转为set，时间O(n)，之后对于
set中的每一个元素，如果是一个连续序列的下边界，则对这个连续序列进行，因为对于每一个连续序列实际只会扫描一遍，所以这个循环
最终是O(n)时间复杂度的。

*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int longest=0;
        for(int i=0;i<nums.length;i++){
            int down=nums[i]-1;
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            int up=nums[i]+1;
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            longest=Math.max(longest,up-down-1);
        }
        return longest;
        
    }
}
