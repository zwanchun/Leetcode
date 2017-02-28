/*4Sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
  */
  
  public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(nums==null||nums.length<4) return rst;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1&&nums[j]==nums[j-1]) continue;
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        List<Integer> tmp=new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        rst.add(tmp);
                        left++;
                        right--;
                        while(left<right&&nums[left]==nums[left-1]) left++;
                        while(left<right&&nums[right]==nums[right+1]) right--;
                    }
                    else if(sum<target) left++;
                    else right--;
                    
                }
            }
        }
        return rst;
        
        
    }
}


/*smallest*4*/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(nums==null||nums.length<4) return rst;
        
        Arrays.sort(nums);
        
        for(int i=0;i<=nums.length-4;i++){
            if(nums[i]*4>target) break;
            if(i!=0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<=nums.length-3;j++){
                if(nums[i]+nums[j]*3>target) break;
                if(j!=i+1&&nums[j]==nums[j-1]) continue;
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    if(nums[i]+nums[j]+nums[left]*2>target) break;
                    int sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        List<Integer> list=new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        rst.add(list);
                        left++;
                        right--;
                        while(left<right&&nums[left]==nums[left-1]) left++;
                        while(left<right&&nums[right]==nums[right+1]) right--;
                    }
                    else if (sum>target){
                        right--;
                    }
                    else left++;
                }
            }
        }
        
        return rst;
        
        
    }
}



