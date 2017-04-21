/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

/*http://www.qiujiawei.com/leetcode-problem-45/
贪心算法：

因为要求的是到达最后一个位置的最小步数，那么先假设最终的跳跃路径S存在，可以知道这个路径必然是从0位置开始跳（设起点为S1=0），S2必然是在A[0]能到达的范围内。S2的取值范围是[S1 + 1, S1 + A[S1]]。

若S2不能直接到达last，则S3存在，且S3的取值范围是[S2 + 1, S2 + A[S2]]。

观察S2和S3的式子可以发现，这个问题是可以用贪心法或者DP处理的。因为每一个阶段的最优解只和上一个阶段有关。

那么对于S(i)，究竟是选D = [S(i - 1) + 1, S(i - 1) + A[S(i - 1)]]这个区间的哪个值呢？ 可以让S(i)逐个取D范围的值， 并计算出 y = MAX( S(i) + A[S(i)] )，那么使得y最大的S(i)，就是局部最优解了。
*/

/*runtime:O(N)*/


public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A==null||A.length<=1) return 0;
        int step=0;
        int max_length=0;
        int current_length=0;
        for(int i=0;i<A.length;i++){
            if(current_length<i){
                step++;
                current_length=max_length;
            }
            max_length=Math.max(max_length,A[i]+i);
        }
        
        return step;
    }
}
