/*Implement int sqrt(int x).

Compute and return the square root of x.
*/

/*runtime:O(logN)
space: O(1)
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x<0) return 0;
        int start=0, end=x;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(Math.pow(mid,2)==x) return mid;
            else if(Math.pow(mid,2)<x){ 
                start=mid;
            }
            else end=mid;
        }
        if(Math.pow(end,2)<=x) return end;
        return start;
    }
}
