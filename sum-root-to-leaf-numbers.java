/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        int sum=0;
        if(root==null) return sum;
        StringBuilder rtl=new StringBuilder();
        sum=dfs(rtl,root,sum);
        return sum;
        
    }
    
    private int dfs(StringBuilder rtl, TreeNode root, int sum){
        rtl.append(root.val);
        if(root.left==null&&root.right==null){
            sum+=Integer.parseInt(rtl.toString());
            return sum;
        }
        
        if(root.left!=null){
            sum=dfs(rtl,root.left,sum);
            rtl.deleteCharAt(rtl.length()-1);
            
        }
        
        if(root.right!=null){
            sum=dfs(rtl,root.right,sum);
            rtl.deleteCharAt(rtl.length()-1);
        }
        
        return sum;
        
        
        
    }
}
