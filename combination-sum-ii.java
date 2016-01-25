/*Combination Sum II
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

/*solution: similar to combination of "Combination Sum" and "Subsets II"
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0) return rst;
        Arrays.sort(candidates);
        if(candidates[0]>target) return rst;
        List<Integer> list=new ArrayList<Integer>();
        helper(rst,list,candidates,target,0);
        return rst;
        
    }
    
    private void helper(List<List<Integer>> rst, List<Integer> list, int[] candidates, int target, int index){
        if(target<=0){
            if(target==0) rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]>target) break;
            if(i!=index&&candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            helper(rst,list,candidates,target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}
