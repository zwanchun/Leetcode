/*Using O(1) time to check whether an integer n is a power of 2.*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if(n<=0) return false;
        int count=0;
        while(n!=0){
            count+=n&1;
            if(count>1) return false;
            n=n>>>1;
            
        }
        return true;
        
    }
};
