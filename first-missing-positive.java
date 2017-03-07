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


/*交换的条件就是3个：

1: A[i] is in the range;
2: A[i] > 0.
3: The target is different; （如果不判断这个，会造成死循环，因为你交换过来一个一样的值）

runtime:O(N)
*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
       if(A==null||A.length==0) return 1;
       int i=0;
       while(i<A.length){
           if(A[i]==i+1||A[i]<=0||A[i]>=A.length||A[i]==A[A[i]-1]) i++;
           else if(A[i]!=i+1){
               int tmp=A[A[i]-1];
               A[A[i]-1]=A[i];
               A[i]=tmp;
           }
       }
       
       for(i=0;i<A.length;i++){
           if(A[i]!=i+1) break;
       }
       
       return i+1; 
    }
}
