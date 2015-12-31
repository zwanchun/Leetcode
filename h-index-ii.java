/*Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/

public class Solution {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int sum=citations.length;
        int imin=0,imax=sum-1;
        while(imin<=imax){
            int imid=imin+(imax-imin)/2;
            if(sum-imid>citations[imid]) imin=imid+1;
            else imax=imid-1;
        }
        return sum-imin;
        
    }
}
