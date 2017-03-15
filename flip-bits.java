/*Determine the number of bits required to flip if you want to convert integer n to integer m.
Both n and m are 32-bit integers.
*/

/*无符号位右移：>>>*/

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int temp=a^b;
        int count=0;
        while(temp!=0){
            count+=temp&1;
            temp=temp>>>1;
        }
        return count;
    }
};
