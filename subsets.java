/*Subsets
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) return rst;
        List<Integer> list=new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(rst,list,nums,0);
      
        return rst;
        
    }
    
    private void helper(List<List<Integer>> rst, List<Integer> list, int[] nums, int start){
        rst.add(new ArrayList<Integer>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            helper(rst,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
