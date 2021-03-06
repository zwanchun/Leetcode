/*Two Sum
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
/* Solution: use hashmap to store value and index, finding target-nums[i]
cannot sort array,because need to return indexes*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length<2) return null;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
           map.put(nums[i],i+1);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])&&map.get(target-nums[i])!=i+1){
                 int[] indexes={i+1,map.get(target-nums[i])};
                 return indexes;
            }
        }
        return null;
        
        
    }
}


public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if(numbers==null||numbers.length<2) return null;
        int[] rst=new int[2];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                rst[0]=map.get(target-numbers[i]);
                rst[1]=i+1;
                break;
            }
            else{
                map.put(numbers[i],i+1);
            }
        }
        
        return rst;
        
    }
}
