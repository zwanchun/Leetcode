/*Range Sum Query - Immutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

/*计算辅助数组sums：

sums[0] = 0

sums[i+1] = sums[i] + nums[i]
则sumRange(i, j) = sums[j+1] - sums[i]
*/

