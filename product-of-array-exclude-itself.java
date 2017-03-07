/*Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.
*/

/*runtime:O(N)
output[i] =  { i 前面的数的乘积}  X  { i 后面的数的乘积}
问题就解决了，首先从前往后扫描数组一遍，对每一个i，得到{i 前面的数的乘积}(可以称做output_before)，然后在从后往前扫描数组一遍，获得 { i 后面的数的乘积}(可以称做output_after)。 将两数相乘即为所求。
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        int len=A.size();
        ArrayList<Long> B=new ArrayList<Long>();
        long[] after=new long[len];
        after[len-1]=1;
        for(int i=len-2;i>=0;i--){
            after[i]=after[i+1]*A.get(i+1);
        }
        
        long before=1;
        
        B.add(before*after[0]);
        
        for(int i=1;i<len;i++){
            before=before*A.get(i-1);
            B.add(before*after[i]);
        }
        
        return B;
    }
}
