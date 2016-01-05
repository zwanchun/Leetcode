/*Basic Calculator
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/

/*solution:
题目中只有+ - ( )。遍历字符串，对于每个字符c：

如果是数字，则一直遍历到非数字字符，把数字找出，并与结果相加
如果是+-符号，将sign设置成对应的值
如果是(，将rst和sign压入栈中，重置rt和sign
如果是)，将sign和rst弹出栈，并计算结果
*/

public class Solution {
    public int calculate(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        
        Stack<Integer> stack=new Stack<Integer>();
        
        int sign=1; //1 represents"+", -1 represents"-"
        int rst=0;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if(Character.isDigit(c)){
                int val=c-'0';
                while(i+1<s.length()&&Character.isDigit(s.charAt(i + 1))){
                    val=10*val+s.charAt(i+1) - '0';
                    i++;
                }
                rst+=sign*val;
            }
            else if(c=='-'){
                sign=-1;
            }
            else if(c=='+'){
                sign=1;
            }else if(c=='('){
                stack.push(rst);
                stack.push(sign);
                rst=0;
                sign=1;
            }else if(c==')'){
                rst=rst*stack.pop()+stack.pop();
                sign=1;
            }
        }
        
        return rst;
        
    }
}
