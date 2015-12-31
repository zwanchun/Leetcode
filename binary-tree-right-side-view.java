/*Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
 
//Mine solution
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst=new ArrayList<Integer>();
        if(root==null) return rst;
        Queue<TreeNode> q1=new LinkedList<TreeNode>();
        Queue<TreeNode> q2=new LinkedList<TreeNode>();
        
        q1.add(root);
      
        while(!q1.isEmpty()){
            TreeNode tmp=q1.remove();
            if(tmp.left!=null) q2.add(tmp.left);
            if(tmp.right!=null) q2.add(tmp.right);
            if(q1.isEmpty()){
                rst.add(tmp.val);
                Queue<TreeNode> tmpq=q1;
                q1=q2;
                q2=tmpq;
            }
              
        }
        
        return rst;
        
        
    }
}
