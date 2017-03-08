/*Merge two given sorted integer array A and B into a new sorted integer array.
*/

/*runtime:O(N+M)
space:O(N+M)
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        if(A==null||B==null) return null;
        int n=A.length;
        int m=B.length;
        
        int[] C=new int[n+m];
        
        int indexA=0;
        int indexB=0;
        int indexC=0;
        
        while(indexA<n&&indexB<m){
            if(A[indexA]<=B[indexB]){
                C[indexC++]=A[indexA++];
            }
            else{
                C[indexC++]=B[indexB++];
            }
        }
        
        while(indexA<n){
            C[indexC++]=A[indexA++];
        }
        
         while(indexB<m){
            C[indexC++]=B[indexB++];
        }
        
        return C;
        
    }
}

/*How can you optimize your algorithm if one array is very large and the other is very small?

应该考虑用一个二分法插入小的
*/
