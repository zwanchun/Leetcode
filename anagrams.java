/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> rst=new ArrayList<List<String>>();
        if(strs==null||strs.length==0) return rst;
        
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        
        for(String s:strs){
            
            char[] str=s.toCharArray();
            Arrays.sort(str);
            String keystr=String.valueOf(str);
            if(!map.containsKey(keystr)) map.put(keystr,new ArrayList<String>());
            map.get(keystr).add(s);
        }
        
        rst.addAll(map.values());
        return rst;
        
    }
}
