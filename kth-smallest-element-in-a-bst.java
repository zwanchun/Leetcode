/*Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
*/

/* solution:
http://bookshadow.com/weblog/2015/07/02/leetcode-kth-smallest-element-bst/
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk=new Stack<TreeNode>();
        TreeNode curr=root;
        int i=0;
        while(curr!=null||!stk.empty()){
            while(curr!=null){
                stk.push(curr);
                curr=curr.left;
            }
            curr=stk.peek();
            k--;
            if(k==0) return curr.val;
            stk.pop();
            curr=curr.right;
        }
        return -1;
        
        
    }

   
}
