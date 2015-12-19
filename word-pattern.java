/*Word Pattern
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null||str==null||pattern.length()==0||str.length()==0) return false;
        String[] words=str.split(" ");
        if(words.length!=pattern.length()) return false;
        HashMap<Character,String> map=new HashMap<Character, String>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words[i])) return false;
            }
            else{
                map.put(pattern.charAt(i),words[i]);
            }
        }
        HashMap<String,Character> map2=new HashMap<String,Character>();
        for(int i=0;i<pattern.length();i++){
            if(map2.containsKey(words[i])){
                if(!map2.get(words[i]).equals(pattern.charAt(i))) return false;
            }
            else{
                map2.put(words[i],pattern.charAt(i));
            }
        }
        return true;
        
    }
}
