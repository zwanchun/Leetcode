/*Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
You couldn't cut wood into float length.

If you couldn't get >= k pieces, return 0.

For L=[232, 124, 456], k=7, return 114.

*/

/* for range 1~max(L[i]), use binary search to find length satisfy pieces number >=k*/

/*runtime:O(NlogLen)*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L==null||L.length==0) return 0;
        int max=0;
        for(int i=0;i<L.length;i++){
            max=Math.max(max,L[i]);
        }

        int start=1;
        int end=max;
    
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(getNumPieces(L,mid)>=k) start=mid;
            else end=mid;
        }
        
        if(getNumPieces(L,end)>=k) return end;
        if(getNumPieces(L,start)>=k) return start;
        return 0;
        
    }
    
    private int getNumPieces(int[] L, int length){
        int num=0;
        for(int i=0;i<L.length;i++){
            num+=L[i]/length;
        }
        return num;
        
    }
}
