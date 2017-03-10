/*Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]

O(nlogn) time

*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */

    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        
        if(nums==null||nums.length==0) return null; 
        if(nums.length==1) return new int[]{0,0}; 
        int[] rst=new int[2];
        Pair[] sums=new Pair[nums.length+1];
        sums[0]=new Pair(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            sums[i+1]=new Pair(sum,i);
        }
        Arrays.sort(sums,new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum-b.sum;
            }
        });
        
        int min_diff=Integer.MAX_VALUE;
        for(int i=1;i<=nums.length;i++){
            if(Math.abs(sums[i].sum-sums[i-1].sum)<min_diff){
                rst[0]=Math.min(sums[i].index,sums[i-1].index)+1;
                rst[1]=Math.max(sums[i].index,sums[i-1].index);
                min_diff=Math.abs(sums[i].sum-sums[i-1].sum);
            }
        }
        
        return rst;
       
    }
}

class Pair{
    int sum;
    int index;
    
    Pair(int sum, int index){
        this.sum=sum;
        this.index=index;
    }
}
