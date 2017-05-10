/*http://www.cnblogs.com/yuzhangcmu/p/4175779.html*/

/*runtime:O(N)
space:O(1)
*/

/*
1. 我们对cnt1,cnt2减数时，相当于丢弃了3个数字（当前数字，n1, n2）。也就是说，每一次丢弃数字，我们是丢弃3个不同的数字。

而Majority number超过了1/3所以它最后一定会留下来。

设定总数为N, majority number次数为m。丢弃的次数是x。则majority 被扔的次数是x

而m > N/3, N - 3x > 0. 

3m > N,  N > 3x 所以 3m > 3x, m > x 也就是说 m一定没有被扔完

最坏的情况，Majority number每次都被扔掉了，但它一定会在n1,n2中。

2. 为什么最后要再检查2个数字呢？因为数字的编排可以让majority 数被过度消耗，使其计数反而小于n2，或者等于n2.前面举的例子即是。
*/


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
