/*Roman to Integer
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

/WIKI:
羅馬數字共有7個，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。按照下述的規則可以表示任意正整數。需要注意的是罗马数字中没有“0”，與進位制無關。一般認為羅馬數字只用來記數，而不作演算。

重複數次：一個羅馬數字重複幾次，就表示這個數的幾倍。
右加左減：
在較大的羅馬數字的右邊記上較小的羅馬數字，表示大數字加小數字。
在較大的羅馬數字的左邊記上較小的羅馬數字，表示大數字减小數字。
左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
但是，左減時不可跨越一個位值。比如，99不可以用IC（100-1）表示，而是用XCIX（[100-10]+[10-1]）表示。（等同於阿拉伯數字每位數字分別表示。）
左減數字必須為一位，比如8寫成VIII，而非IIX。
右加數字不可連續超過三位，比如14寫成XIV，而非XIIII。（見下方“數碼限制”一項。）
加線乘千：
在羅馬數字的上方加上一條橫線或者加上下標的Ⅿ，表示將這個數乘以1000，即是原數的1000倍。
同理，如果上方有兩條橫線，即是原數的1000000（1000^{2}）倍。
數碼限制：
同一數碼最多只能连续出現三次，如40不可表示為XXXX，而要表示為XL。
例外：由於IV是古羅馬神話主神朱庇特（即IVPITER，古羅馬字母裡沒有J和U）的首字，因此有時用IIII代替IV。
*/

public class Solution {
    
    private HashMap<Character,Integer> map;
    
    public Solution(){
        map=new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
    public int romanToInt(String s) {
        if(s==null||s.length()==0) return 0;
        int num=0;
        Stack<Character> stk=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(!stk.empty()){
                char c=stk.peek();
                if(map.get(s.charAt(i))>map.get(c)){
                    stk.pop();
                    num=num+map.get(s.charAt(i))-map.get(c);
                }
                else stk.push(s.charAt(i));
                
            }
            else stk.push(s.charAt(i));
        }
        while(!stk.empty()){
            char c=stk.pop();
            num+=map.get(c);
        }
        return num;
        
    }
 
}   

/*
public class Solution {
 	public int romanToInt(String s) {
	    if (s == null || s.length()==0) {
 return 0;
	    }
	    Map<Character, Integer> m = new HashMap<Character, Integer>();
	    m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);

	    int length = s.length();
	    int result = m.get(s.charAt(length - 1));
	    for (int i = length - 2; i >= 0; i--) {
	        if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
	            result += m.get(s.charAt(i));
	        } else {
	            result -= m.get(s.charAt(i));
	        }
	    }
	    return result;
	}
}
*/
   
