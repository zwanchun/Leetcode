/*Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  */
  
  public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0) return 0;
        Stack<Integer> stk=new Stack<Integer>();
        for(String t:tokens){
            if(t.equals("+")){
                if(stk.size()<2) return 0;
                stk.push(stk.pop()+stk.pop());
            }
            else if(t.equals("-")){
                if(stk.size()<2) return 0;
                stk.push(-stk.pop()+stk.pop());
            }
            else if(t.equals("*")){
                if(stk.size()<2) return 0;
                stk.push(stk.pop()*stk.pop());
            }
            else if(t.equals("/")){
                 if(stk.size()<2) return 0;
                 int temp=stk.pop();
                 if(temp==0) return 0;
                 stk.push(stk.pop()/temp);
            }
            else{
                stk.push(Integer.parseInt(t));
            }
            
        }
        return stk.pop();
        
    }
}
