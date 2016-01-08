/* Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(n<1||k>n) return rst;
        List<Integer> list=new ArrayList<Integer>();
        helper(rst,list,n,k,1);
        return rst;
        
    }
    
    private void helper(List<List<Integer>> rst, List<Integer> list, int n, int k, int start){
        if(list.size()==k){
            rst.add(new ArrayList(list));
            return;
        }
        
        for(int i=start;i<=n;i++){
            list.add(i);
            helper(rst,list,n,k,i+1);
            list.remove(list.size()-1);
        }
    }
}
