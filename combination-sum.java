/*Combination Sum
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(candidates==null||target==0||candidates.length==0) return rst;
        Arrays.sort(candidates);
        if(candidates[0]>target) return rst;
        List<Integer> comb=new ArrayList<Integer>();
        helper(rst,comb,candidates, target, 0);
        return rst;
        
    }
    
    private void helper(List<List<Integer>> rst, List<Integer> comb, int[] candidates, int target, int index){
        if(target==0){
            rst.add(new ArrayList<Integer>(comb));
            return;
        }
        else if(target<0){
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]>target) break;
            target-=candidates[i];
            comb.add(candidates[i]);
            helper(rst,comb,candidates,target,i);
            target+=comb.get(comb.size()-1);
            comb.remove(comb.size()-1);
        }
       
        
    }
}
