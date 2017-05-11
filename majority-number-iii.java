/*runtime:O(N)
space:O(K)
*/


public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if(nums==null||nums.size()==0) return Integer.MIN_VALUE;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(Integer i:nums){
            if(!map.containsKey(i)) map.put(i,1);
            else{
                map.put(i,map.get(i)+1);
            }
            
            if(map.size()>=k) remove(map);
        }
        
        if(map.size()==0) return Integer.MIN_VALUE;
        
        for(Integer i:map.keySet()){
            map.put(i,0);
        }
        
        for(Integer i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
        }
        
        int maxcount=0, majornum=0;
        
        for(Integer i:map.keySet()){
            if(map.get(i)>maxcount){
                maxcount=map.get(i);
                majornum=i;
            }
            
            
        }
        
        return majornum;
        
        
        
    }
    
    private void remove(Map<Integer,Integer> map){
        Set<Integer> set=map.keySet();
        List<Integer> removelist=new ArrayList<Integer>();
        for(Integer i:set){
            map.put(i,map.get(i)-1);
            if(map.get(i)==0) removelist.add(i);
        }
        
        for(Integer i:removelist){
            map.remove(i);
        }
    }
}
