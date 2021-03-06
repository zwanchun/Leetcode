/*Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
*/

/*solution:
可以看到n位的格雷码由两部分构成，一部分是n-1位格雷码，再加上 1<<(n-1)和n-1位格雷码的逆序（整个格雷码逆序0132变成2310这种）的和。

 

1位格雷码有两个码字 
(n+1)位格雷码中的前2^n个码字等于n位格雷码的码字，按顺序书写，加前缀0 
(n+1)位格雷码中的后2^n个码字等于n位格雷码的码字，按逆序书写，加前缀1。

由于是二进制，在最高位加0跟原来的数本质没有改变，所以取得上一位算出的格雷码结果，再加上逆序添1的方法就是当前这位格雷码的结果了。

n = 0时，[0]

n = 1时，[0,1]

n = 2时，[00,01,11,10]

n = 3时，[000,001,011,010,110,111,101,100]

 

当n=1时，0，1

当n=2时，原来的list 0，1不变，只是前面形式上加了个0变成00，01。然后加数是1<<1为10，依次：10+1=11 10+0=10。结果为：00 01 11 10

当n=3时，原来的list 00,01,11, 10（倒序为：10，11，01，00）。加数1<<2为100。倒序相加为：100+10=110, 100+11=111,100+01=101, 100+00= 100。
*/

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> rst=new ArrayList<Integer>();
        if(n<=1){
            for(int i=0;i<=n;i++){
                rst.add(i);
            }
            return rst;
        }
        rst=grayCode(n-1);
        List<Integer> r1=reverse(rst);
        int x=1<<(n-1);
        for(int i=0;i<r1.size();i++){
            r1.set(i,r1.get(i)+x);
        }
        rst.addAll(r1);
        return rst;
        
    }
    
    private List<Integer> reverse(List<Integer> r){
        List<Integer> rev=new ArrayList<Integer>();
        for(int i=r.size()-1;i>=0;i--){
            rev.add(r.get(i));
        }
        return rev;
    }
}

最终结果为000 001 011 010 110 111 101 100 
