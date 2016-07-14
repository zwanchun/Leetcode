public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        if(nums==null||nums.length==0) return res;
        int candidate1=0, candidate2=0;
        int count1=0, count2=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=candidate1&&nums[i]!=candidate2){
        		if(count1==0) candidate1=nums[i];
        		else if(count2==0) candidate2=nums[i];
        	}
            
            if(nums[i]==candidate1) count1++;
            else if(nums[i]==candidate2) count2++;
            else{
                count1--;
                count2--;
            }
        }
        count1=0; 
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate1) count1++;
            else if(nums[i]==candidate2) count2++;
        }
        
        if(count1>nums.length/3) res.add(candidate1);
        if(count2>nums.length/3) res.add(candidate2);
        
        return res;
    }
}
