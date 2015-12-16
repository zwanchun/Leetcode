/*Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(height(root.left)-height(root.right))>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
        
    }
    
    public int height(TreeNode t){
        if(t==null) return -1;
        return 1+Math.max(height(t.left),height(t.right));
    }
}
