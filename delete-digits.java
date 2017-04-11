/*Given string A representative a positive integer which has N digits, remove any k digits of the number, the remaining digits are arranged according to the original order to become a new positive integer.

Find the smallest integer after remove k digits.

N <= 240 and k <= N,

Given an integer A = "178542", k = 4

return a string "12"
*/


/*loop string from left to right, delete digit which is larger than the next digit*/

/*runtime:O(N)*/



public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if(A==null||A.length()==0||k<=0) return A;
        
        StringBuilder sb=new StringBuilder(A);
        
        int index=0;
        while(k>0){
            if(index==sb.length()-1){
                sb.deleteCharAt(sb.length()-1);
                k--;
                index--;
            }
            else if(sb.charAt(index)<=sb.charAt(index+1)){
                index++;
            }
            else{
                sb.deleteCharAt(index);
                k--;
                if(index>0) index--;
            }
        }
        
        while(sb.length()>0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
        
    }
}

