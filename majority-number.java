/*Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums==null||nums.size()==0) return 0;
        int rst=0;
        int count=0;
        for(int i=0;i<nums.size();i++){
            if(count==0){
                rst=nums.get(i);
                count++;
            }
            else if(nums.get(i)==rst) count++;
            else count--;
        }
        
        return rst;
    }
}
