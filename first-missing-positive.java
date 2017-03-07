/*Given an unsorted integer array, find the first missing positive integer.
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

/*runtime:O(N)
space:O(N)
*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<A.length;i++){
            set.add(A[i]);
        }
        int i=1;
        for(;i<=A.length;i++){
            if(!set.contains(i)) break;
        }
        return i;
    }
}
