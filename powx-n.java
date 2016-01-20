/*Pow(x, n)
Implement pow(x, n).
*/

/*solution:
http://www.cnblogs.com/yuzhangcmu/p/4174683.html
使用二分法。

1. 负数的情况，使用以下的公式转化为求正数power，另外，考虑到MIN_VALUE可能会造成越界的情况，我们先将负数+1：

X^(-n) = X^(n + 1) * X
X^n = 1/(x^(-n))

2. Base case: pow = 0, RESULT = 1;

3. 正数的时候，先求n/2的pow，再两者相乘即可。

当n = -2147483648 必须要特别处理，因为对这个数取反会得到相同的数（已经越界）
所以当n为负时，先加个1再说。具体可以看代码。

先计算出x的n/2次方，再自乘一下。另外，注意n%2如果为1，
记得再乘以x

如果n是负数，所有计算完成后，执行x=1/x就行
*/

public class Solution {
    public double myPow(double x, int n) {
       if(x==0) return 0;
       if(n==0) return 1;
       if(n==1) return x;
       
       //when n=-2147483648,-n=n, therefore n add one then plus x
       if(n<0){
          double rst=x*myPow(x,-(n+1));
          return 1/rst;
       }
       
       double rst=myPow(x,n/2);
       rst=rst*rst;
       
       if(n%2!=0){
           rst*=x;
       }
       
       return rst;
        
    }
}
