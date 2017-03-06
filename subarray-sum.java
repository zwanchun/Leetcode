/*Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
*/

/*Runtime:O(N^2)
Space:O(1)
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(nums==null||nums.length==0) return list; 
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==0){
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
        }
        
        return list;
    }
}

/*runtime:O(N)
space:O(N)

sum(i)-sum(j)=0  =>sum(i)=sum(j)
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(nums==null||nums.length==0) return list; 
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                list.add(map.get(sum)+1);
                list.add(i);
                break;
            }
            else{
                map.put(sum,i);
            }
        }
        return list;
    }
}
