/*Calculate the an % b where a, b and n are all 32bit integers.
*/

/*runtime:O(logN)*/

/*(a * b) % p = ((a % p) * (b % p)) % p
https://algorithm.yuanbin.me/zh-hans/math_and_bit_manipulation/fast_power.html*/

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(n==1) return a%b;
        else if(n==0) return 1%b;
        else if(n<0) return -1;
        
        long product= fastPower(a,b,n/2);
        product=(product*product)%b;
        if(n%2==1){
            product=(product*(a%b))%b;
        }
        
        return (int)product;
    }
}
