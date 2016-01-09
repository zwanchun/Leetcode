/*Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rst=new ArrayList<String>();
        if(n<=0) return rst;
        helper(rst,"",n,n);
        return rst;
        
        
    }
    
    private void helper(List<String> rst, String str, int left, int right){
        if(left==0&&right==0){
            rst.add(str.toString());
            return;
        }
        if(left>0){
            helper(rst,str+"(",left-1,right);
        }
        if(right>0&&left<right){
            helper(rst,str+")",left,right-1);
        }
    }
}
