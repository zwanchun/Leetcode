/*Minimum Size Subarray Sum
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

*/

/*solution:
思路：此题与最大和子序列比较类似，都是使用dp的思想。本题要求字数组的长度，故使用双指针维护一个窗口，来遍历数组，左右指针的距离即为本体的解。移动方法是：如果窗内元素和大于指定值ｓ，则比较当前窗长和最小窗长，并移动左指针，反之移动右指针。
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i,j=0;
        int sum=0;
        int minsize=Integer.MAX_VALUE;
        for(i=0;i<nums.length;i++){
            while(j<nums.length&&sum<s){
                sum+=nums[j];
                j++;
            }
            if(sum>=s) minsize=Math.min(minsize,j-i);
            sum-=nums[i];
            
        }
        if(minsize==Integer.MAX_VALUE){
            return 0;
        }
        return minsize;
        
        
    }
}
