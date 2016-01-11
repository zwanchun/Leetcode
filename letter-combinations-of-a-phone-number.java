/* Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> rst=new ArrayList<String>();
        if(digits==null||digits.length()==0) return rst;
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder str=new StringBuilder();
        helper(rst,str,map,digits,0);
        return rst;
    }
    
    private void helper(List<String> rst, StringBuilder str, String[] map, String digits, int start){
        if(str.length()==digits.length()){
            rst.add(str.toString());
            return;
        }
        
        for(int i=start;i<digits.length();i++){
            int num=digits.charAt(i)-'0';
            for(int j=0;j<map[num].length();j++){
                str.append(map[num].charAt(j));
                helper(rst,str,map,digits,i+1);
                str.deleteCharAt(str.length()-1);
            }
        }
    }
}
