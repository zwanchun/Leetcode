/*Integer to Roman
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

/*Solution:
对于一个确定的整数，其实是对每一位进行拆分的。比如3987这个数，可以看成3000+900+80+7，而每一个数字可以表示成对应的罗马字符组成。所以我们只需要把所有可能的数字和罗马字符的对应关系列出来，再拼凑上去就好。

只是注意两个特别的数字，4和9，表示方法稍微有点区别，也需要单独列出来。

最后只需要对给定数字循环处理，输出最后结果即可。

罗马数字对于每个位有三个单位：1,5,10，对于1到9，表示方法如下：
1-3：用1表示；
4:1：5左边加一个1；
5： 直接用5表示； 
6-8: 5右边加相应的1；
9： 10左边加一个1。
*/

public class Solution {
    public String intToRoman(int num) {
        if(num<=0) return "";
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int digit=0;
        StringBuilder res=new StringBuilder();
        while(num>0){
            int times=num/nums[digit];
            num-=times*nums[digit];
            for(;times>0;times--){
                res.append(symbols[digit]);
            }
            digit++;
        }
        return res.toString();
        
    }
}

