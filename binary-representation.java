/*Given a (decimal - e.g. 3.72) number that is passed in as a string, return the binary representation that is passed in as a string. If the fractional part of the number can not be represented accurately in binary with at most 32 characters, return ERROR.
*/

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if(n==null||n.length()==0) return "ERROR";
        
        if(n.indexOf(".")==-1) return parseInteger(n);
        
        String[] params=n.split("\\.");
        String flt=parseFloat(params[1]);
        if(flt.equals("ERROR")){
            return flt;
        }
        else if(flt.equals("")||flt.equals("0")){
            return parseInteger(params[0]);
        }
        return parseInteger(params[0])+"."+flt;
        
    }
    
    private String parseInteger(String str){
        if(str.equals("")||str.equals("0")) return "0";
        int n=Integer.parseInt(str);
        String binary="";
        while(n!=0){
            binary=Integer.toString(n%2)+binary;
            n=n/2;
        }
        return binary;
    }
    
    private String parseFloat(String str){
        double d=Double.parseDouble("0."+str);
        Set<Double> set=new HashSet<Double>();
        String binary="";
        while(d>0){
            if(binary.length()>32||set.contains(d)){
                return "ERROR";
            }
            set.add(d);
            d=d*2;
            if(d>=1){
                binary=binary+"1";
                d=d-1;
            }
            else{
                binary=binary+"0";
            }
        }
        
        return binary;
        
    }
}
