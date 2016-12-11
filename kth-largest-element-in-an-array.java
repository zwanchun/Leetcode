/* solution 1:
use priority queue
*/


public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums==null||nums.length==0||k<=0) return 0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        
        for(int i=0;i<nums.length-k;i++){
            pq.poll();
        }
        
        return pq.peek();
        
    }
}
