/*Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

/* solution:
http://www.cnblogs.com/TenosDoIt/p/3795342.html
最直观的方法是，用被除数逐个的减去除数，直到被除数小于0。这样做会超时。

那么如果每次不仅仅减去1个除数，计算速度就会增加，但是题目不能使用乘法，因此不能减去k*除数，我们可以对除数进行左移位操作，这样每次相当于减去2^k个除数，如何确定k呢，只要使 (2^k)*除数 <=  当前被除数 <(2^(k+1))*除数.

pay attention to Integer overflow

*/

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0){
            return dividend>=0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        
        if(dividend==0) return 0;
        
        boolean isNegative=(dividend<0&&divisor>0)||(dividend>0&&divisor<0); 
        
        
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        
        long result=0;
        
        while(a>=b){
            long shift=0;
            
            while(a>=(b<<shift)){
                shift++;
              
            }
            
            a-=(b<<(shift-1));
            result+=((long)1)<<(shift-1);
            
        }
        
        if(result>Integer.MAX_VALUE) return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        
        return isNegative?(int)-result:(int)result;
        
    }
}

