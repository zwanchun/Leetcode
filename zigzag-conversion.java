/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/


/* reference: http://www.cnblogs.com/springfor/p/3889414.html
runtime: O(N)
*/

public class Solution {
    public String convert(String s, int numRows) {
        if(s==null||s.length()==0||numRows<=0) return "";
        if(s.length()<numRows||numRows==1) return s;
        
        StringBuilder sb=new StringBuilder();
        
        int divisor=numRows*2-2;
        int length=s.length();
        
        for(int i=0;i<numRows;i++){
            for(int j=i;j<length;j+=divisor){
                sb.append(s.charAt(j));
                if((i!=0&&i!=numRows-1)&&j+2*(numRows-i-1)<length){
                    sb.append(s.charAt(j+2*(numRows-i-1)));
                }
            }
            
        }
        
        return sb.toString();
        
        
        
    }
}
