/*Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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
    
    private TreeNode tmp=new TreeNode(0);
    
    public void flatten(TreeNode root) {
        if(root==null) return;
        tmp.left=null;
        tmp.right=root;
        tmp=root;
        TreeNode right=root.right;//if not stored, the right node of root would change during recursion
        flatten(root.left);
        flatten(right);
        
        
    }
}
