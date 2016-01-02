/*Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/*solutions:
1. Method 1 (Simple)
Following is a simple algorithm where we first find the middle node of list and make it root of the tree to be constructed.
Time complexity: O(nLogn) where n is the number of nodes in Linked List.

2. Method 2 (Tricky) 
The method 1 constructs the tree from root to leaves. In this method, we construct from leaves to root. The idea is to insert nodes in BST in the same order as the appear in Linked List, so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we allocate memory for root and link the left subtree with root. Finally, we recursively construct the right subtree and link it with root.
While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    
    private ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) {
        int size=getSize(head);
        current=head;
        return sortedListToBST(size);
        
    }
    
    private int getSize(ListNode head){
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        return size;
    }
    
    private TreeNode sortedListToBST(int size){
        if(size<=0) return null;
        TreeNode left=sortedListToBST(size/2);
        TreeNode root=new TreeNode(current.val);
        current=current.next;
        TreeNode right=sortedListToBST(size-size/2-1);//-1 because need to rule out the root
        root.left=left;
        root.right=right;
        return root;
    }
}
