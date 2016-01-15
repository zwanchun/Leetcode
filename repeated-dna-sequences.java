/*Repeated DNA Sequences
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rst=new ArrayList<String>();
        if(s==null||s.length()<10) return rst;
        Set<String> hashset=new HashSet<String>();
        Set<String> result=new HashSet<String>();
        for(int i=9;i<s.length();i++){
            String substring=s.substring(i-9,i+1);
            if(hashset.contains(substring)){
                result.add(substring);
            }
            else{
                hashset.add(substring);
            }
        }
        
        for(String str:result){
            rst.add(str);
        }
        return rst;
    }
}
