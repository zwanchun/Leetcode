/*Maximum Product of Word Lengths
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/

/*solution:
http://bookshadow.com/weblog/2015/12/16/leetcode-maximum-product-word-lengths/
*/

public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] elements = new int[n];
        for (int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                elements[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
 
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((elements[i] & elements[j]) == 0)
                    ans = Math.max(ans,words[i].length() * words[j].length());
            }
        }
        return ans;
        
        
    }
}
