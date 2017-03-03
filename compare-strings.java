/*Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

 Notice

The characters of B in A are not necessary continuous or ordered.

Example
For A = "ABCD", B = "ACD", return true.

For A = "ABCD", B = "AABC", return false.*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(A==null||B==null) return false;
        if(A.length()<B.length()) return false;
        
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        
        for(int i=0;i<A.length();i++){
            if(map.containsKey(A.charAt(i))){
                map.put(A.charAt(i),map.get(A.charAt(i))+1);
            }
            else{
                map.put(A.charAt(i),1);
                
            }
        }
        
        for(int i=0;i<B.length();i++){
            if(!map.containsKey(B.charAt(i))) return false;
            if(map.get(B.charAt(i))==0) return false;
            map.put(B.charAt(i),map.get(B.charAt(i))-1);
        }
        
        return true;
    }
}
