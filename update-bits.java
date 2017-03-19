/*Given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e g , M becomes a substring of N located at i and starting at j)
*/

/*https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72988*/

/*runtime:O(1)*/

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int ones=~0;
        int left=0;
        if(j!=31) left=ones<<(j+1);
        int right=(1<<i)-1;
        int mask=left+right;
        return (n&mask)|(m<<i);
        
    }
}
