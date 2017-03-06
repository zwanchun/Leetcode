/*Given two sorted integer arrays A and B, merge B into A as one sorted array.
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/

/* runtime: O(M*N)*/
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int indexA=m-1;
        int indexB=0;

        for(;indexB<n;indexB++){
        	int i=indexA;
        	for(;i>=0;i--){
        		if(A[i]>B[indexB]){
        			A[i+1]=A[i];
        		}
        		else{
        		
        			break;
        		}
        	}	
        	A[i+1]=B[indexB];
        	indexA++;
    
        }

       
    }
}
