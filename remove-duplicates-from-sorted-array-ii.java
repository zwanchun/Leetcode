/*Remove Duplicates from Sorted Array II
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

/*runtime: O(N)
space:O(1)
https://siddontang.gitbooks.io/leetcode-solution/content/array/remove_duplicates_from_sorted_array.html
*/


public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums==null||nums.length<=1) return nums.length;
        int start=0;
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[start]){
                count++;
                if(count<2){
                    nums[++start]=nums[i];
                }
            }
            else{
                nums[++start]=nums[i];
                count=0;
            }
           
        }
        
        return start+1;
        
       
    }
}
