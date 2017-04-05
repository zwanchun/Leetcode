/*Given a list of non negative integers, arrange them such that they form the largest number.
*/

/*runtime:O(NlogN)
compare s1+s2, s2+s1*/

public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        if(num==null||num.length==0) return null;
        StringBuilder sb=new StringBuilder();
        String[] temp=new String[num.length];
        for(int i=0;i<num.length;i++){
            temp[i]=Integer.toString(num[i]);
        }
        Arrays.sort(temp, new NumberComparator());
        if(temp[0].equals("0")) return "0";
        for(int i=0;i<temp.length;i++){
            sb.append(temp[i]);
        }
        
        return sb.toString();
        
    }
    
    
}


class NumberComparator implements Comparator<String>{
  
        public int compare(String s1, String s2){
            return (s2+s1).compareTo(s1+s2);
        }
        
}
