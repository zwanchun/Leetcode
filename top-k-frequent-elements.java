/*Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

/* using hashmap to calculate the frequency of each number
and use bucket sort to sort the frequency

time complexity: O(N)
space complexity: O(N)

*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer> rst=new ArrayList<Integer>();
        
        if(nums==null||nums.length==0||k==0) return rst;
        
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        
        List<Integer>[] bucket=new List[nums.length+1];
        
        for(Integer num:map.keySet()){
            int freq=map.get(num);
            if(bucket[freq]==null)
                bucket[freq]=new ArrayList<Integer>();
            bucket[freq].add(num);
        }
        
        for(int i=bucket.length-1;i>=0&&rst.size()<k;i--){
            if(bucket[i]!=null) rst.addAll(bucket[i]);
        }
        
        return rst;
        
        
    }
}
