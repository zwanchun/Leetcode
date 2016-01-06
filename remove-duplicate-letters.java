/*Remove Duplicate Letters
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/

/*solution:
思想是：维护一个栈Stack<Character> st来存最后的结果，先scan一次input，构造一个字典int[] count，记录每个char出现次数。然后进行第二次scan,用st来存最后在string里的character

这次scan的时候，需要维护一个boolean[] visited, 来记录每个字符是否在当前储存结果的stack里。因为每个字符在结果里只会出现一次，所以如果visited显示某个字符已经在stack里，就不要再添加同样字符了

开始scan，这时候count数组意义变成：remain input里各个字符remain的情况。

遇到一个字符，

1. count数组对应次数减一

2. 检查是否result stack里已经存在这个字符c，如果存在，不再加入（continue就好了）

3. 尝试把这个字符c加入stack，就需要检查当前栈顶往下依次各个字符是不是比c大，而且后面还有这些字符（不是最后一次出现），如果满足这两个条件，可以pop它们。不满足就不能pop

4. stack的历史遗留问题处理完毕后，c入栈，同时设置visited

这样最后stack里面就是字符序的possible result
*/

public class Solution {
    public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0)
			return "";
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[26];
		int[] count = new int[26];

		for (int i = 0; i < s.length(); i++) {
			count[(int) (s.charAt(i) - 'a')]++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			count[(int) (c - 'a')]--;
			if (visited[(int) (c - 'a')])
				continue; // stack already has this char, do not add this to
							// result stack
			// check if we should delete chars from stack
			while (!st.isEmpty() && st.peek() > c && count[(int) (st.peek() - 'a')] > 0) {
				visited[(int) (st.peek() - 'a')] = false;
				st.pop();
			}
			st.push(c);
			visited[(int) (c - 'a')] = true;
		}

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		sb = sb.reverse();
		return sb.toString();
	}
}
