/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

/*
runtime: O(N)
space: O(N)
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0)
            return new int[0];
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        Set<Integer> rstset=new HashSet<Integer>();
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                rstset.add(nums2[i]);
            }
        }
        
        int[] rst=new int[rstset.size()];
        int index=0;
        for(Integer i: rstset){
            rst[index++]=i;
        }
        return rst;
        
        
    }
}
