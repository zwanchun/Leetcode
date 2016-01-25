/*Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) return rst;
        List<Integer> list=new ArrayList<Integer>();
        Arrays.sort(nums);
        dps(rst,list,nums,0);
        return rst;
        
    }
    
    private void dps(List<List<Integer>> rst, List<Integer> list, int[] nums, int index){
        rst.add(new ArrayList(list));
        
        for(int i=index;i<nums.length;i++){
            if(i!=index&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            dps(rst,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
