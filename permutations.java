/*Permutations
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) return rst;
        
        List<Integer> list=new ArrayList<Integer>();
        helper(rst,list,nums);
        return rst;
    }
    
    private void helper(List<List<Integer>> rst, List<Integer> list, int[]nums){
        if(list.size()==nums.length){
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(rst,list,nums);
            list.remove(list.size()-1);
        }
    }
}
