/*Permutation Sequence
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

/*solution:
http://www.tuwenzhai.com/d/94558250-815c-4b50-95f3-68d2ed883cd1/839aa32f-56d7-4815-8211-01ec9fbd8d23
http://www.jiuzhang.com/solutions/permutation-sequence/
http://www.cnblogs.com/yuzhangcmu/p/4224575.html
*/

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        int fac=1;
        for(int i=1;i<=n;i++){
            fac*=i;
        }
        if(k<=0||k>fac) return sb.toString();
        boolean[] used=new boolean[n];
        k=k-1;
        for(int i=0;i<n;i++){
        	fac/=(n-i);
            int index=k/fac;
            k=k%fac;
            for(int j=0;j<n;j++){
            	if(used[j]==false){
            		if(index==0){
            			sb.append(j+1);
            			used[j]=true;
            			break;
            		}
            		else index--;
            	}
            }
               
        }
        return sb.toString();
        
        
    }
}
