/*Implement strStr()
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null) return -1;
        if(haystack.length()<needle.length()) return -1;
        if(needle.length()==0) return 0;
        int index=-1;
        for(int i=0;i<haystack.length();i++){
            if(haystack.length()-i<needle.length()) break;
            if(haystack.charAt(i)==needle.charAt(0)){
                index=i;
                for(int j=1,k=i+1;j<needle.length();j++,k++){
                    if(haystack.charAt(k)!=needle.charAt(j)){
                        index=-1;
                        break;
                    }
                }
                if(index!=-1) return index;
            }
        }
        return -1;
        
    }
}

//other solutions:
public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }


/*my solution*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if(source==null||target==null) return -1;
        if(source.length()<target.length()) return -1;
        if(target.length()==0) return 0;
        
        for(int i=0;i<=source.length()-target.length();i++){
            if(source.charAt(i)==target.charAt(0)){
                int j=1;
                for(;j<target.length();j++){
                    if(source.charAt(i+j)!=target.charAt(j)) break;
                }
                if(j==target.length()) return i;
            }
        }
        
        return -1;
    }
}
