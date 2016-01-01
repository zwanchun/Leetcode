/*Bitwise AND of Numbers Range
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/

/*solution:
假如说5:101  7:111  连续几个数相与的规律：一，只要是相同的位置的数字不相同最后那个位置的结果一定是0 。二，如果高位不相同，从不相同的那位到最低位都会为0，例如5和7虽然第0位相同但是由于第一位不相同，所以最后结果第0位 和第一位都为0。  

如果理解了第二个规律就好办了，如果另个数位数不相同肯定最后结果为0，如果位数相同，从最高位开始寻找，将第一次发现不相同的那一位到最低位都置为0；


代码中，通过不断地右移直到两个数字相等，然后再左移相同的位数，这样做的效果其实就是将位置不相同的都置为0

[m, n]范围的按位与的结果为m与n的公共“左边首部（left header）”
*/

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int pass=0;
        while(m!=n&&m!=0){
            m>>=1;
            n>>=1;
            pass++;
        }
        return m<<=pass;
        
    }
}
