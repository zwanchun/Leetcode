/*Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

/*solution: http://www.jiuzhang.com/solutions/permutations-ii/
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) return rst;
        Arrays.sort(nums);
        boolean[] visit=new boolean[nums.length];
        List<Integer> list=new ArrayList<Integer>();
        helper(rst,list,nums,visit);
        return rst;
    }
    
    private void helper(List<List<Integer>> rst, List<Integer> list, int[] nums, boolean[] visit){
        if(list.size()==nums.length){
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            //排列的时候把sort后的array中相同的index较大的element放在前面
            if(visit[i]||i!=0&&visit[i-1]&&nums[i]==nums[i-1]){
                continue;
            }
            visit[i]=true;
            list.add(nums[i]);
            helper(rst,list,nums,visit);
            list.remove(list.size()-1);
            visit[i]=false;
        }
    }
}
