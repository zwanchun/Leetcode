/*Container With Most Water
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

/*solution:
题目说的有点复杂，大意是利用x轴作底，两个任意的竖直线段作杯壁，何时盛水最多。
木桶原理大家肯定都知道，水盛多少取决于最短的杯壁，所以此题还可以引申为往围成的区域内放矩形，怎样使得矩形面积最大。题目中的不能倾斜（slant：倾斜，倾倒）对应为矩形必须水平放置。

复杂度为O（n）的思想是贪心原理，先从底边最大的情况考虑，计算最大面积后，此时要将底边长度减1，只需要将杯壁较短的那一边移动一个单位距离，得到的解必定优于杯壁较长那边移动的情况。这样保证每次移动都得到的是局部最优解。
*/

public class Solution {
    public int maxArea(int[] height) {
        int maxarea=0, left=0,right=height.length-1;
        while(left<right){
            maxarea=Math.max(maxarea,computeArea(left,right,height));
            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxarea;
        
    }
    
    private int computeArea(int left, int right, int[] height){
        return (right-left)*Math.min(height[left], height[right]);
    }
}
