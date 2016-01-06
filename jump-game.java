/*Jump Game
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

/*solution:
http://www.acmerblog.com/leetcode-solution-jump-game-6217.html
过每个index查看能到的最远的index，若当前最远的比遍历index还小或者相等时就走不下去了。
*/

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0) return true;
        int maxfar=0;
        for(int i=0;i<nums.length;i++){
            maxfar=Math.max(maxfar,i+nums[i]);
            if(maxfar>=nums.length-1) return true;
            if(maxfar<=i) return false;
        }
        return false;
    }
}
