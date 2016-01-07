/*Construct Binary Tree from Inorder and Postorder Traversal
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null||inorder.length!=postorder.length||postorder.length==0) return null;
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        
    }
    
    private int findPosition(int[] arr, int start, int end, int key){
        for(int i=start;i<=end;i++){
            if(arr[i]==key) return i;
        }
        return -1;
        
    }
    
    private TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
        if(instart>inend) return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int position=findPosition(inorder,instart, inend, postorder[postend]);
        int num=position-instart;
        root.left=buildTree(inorder,instart,position-1,postorder,poststart, poststart+num-1);
        root.right=buildTree(inorder,position+1,inend, postorder, poststart+num, postend-1);
        return root;
    }
}
