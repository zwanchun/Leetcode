/*Combination Sum III
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(n<1||k<1||n>=9*k&&k!=1) return rst;
        List<Integer> list=new ArrayList<Integer>();
        dps(rst,list,k,n,1);
        return rst;
        
    }
    
    private void dps(List<List<Integer>> rst, List<Integer> list, int k, int n, int index){
        if(k==0){
            if(n==0) rst.add(new ArrayList<Integer>(list));
            else return;
        }
        
        for(int i=index;i<=9;i++){
            if(n<i) break;
            list.add(i);
            dps(rst,list,k-1,n-i,i+1);
            list.remove(list.size()-1);
        }
        
        
    }
}
