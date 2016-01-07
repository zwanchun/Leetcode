/*Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

/*solution:https://siddontang.gitbooks.io/leetcode-solution/content/tree/construct_binary_tree.html*/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length!=inorder.length) return null;
        return buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
        
        
    }
    
    private int findPosition(int[] arr, int start, int end, int key){
        for(int i=start;i<=end;i++){
            if(arr[i]==key) return i;
        }
        return -1;
    }
    
    private TreeNode buildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend){
        if(instart>inend) return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int position=findPosition(inorder,instart,inend,preorder[prestart]);
        int num=position-instart;
        root.left=buildTree(inorder,instart,position-1,preorder,prestart+1,prestart+num);
        root.right=buildTree(inorder,position+1,inend, preorder, prestart+num+1,preend);
        return root;
    }
}
