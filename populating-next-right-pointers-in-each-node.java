/*Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

*/

/*Solution:
如果不考虑空间存储的话，可以使用深搜的方法，即从右向左搜，对每一个深度都存储一个临时节点，这样当下次搜到该深度的节点，就把这个节点的next赋值为之前记录的那个节点。但由于题目中要求只能设置常数级的变量。所以我们考虑用另外一种递归的方法，这种方法可以让空间复杂度为O(1)，时间为O(n),方法如下：

对于每一个节点，我们做以下几件事：

1.如果有左儿子（根据题目中说了为完全二叉树），所以肯定有右儿子，则把左子树的next节点赋值成右儿子。

2.如果有右儿子，则判断根节点是否有next ，如果有，则将右儿子的next设置为根节点的next的左儿子。

3.递归处理左儿子。

4.递归处理右儿子。

并且注意虽然1,2分别要求的是有左儿子和右儿子，但实际条件是相同的。
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode parent=root;
        TreeLinkNode next=parent.left;
        while(parent!=null&&next!=null){
            TreeLinkNode prev=null;
            while(parent!=null){
                if(prev==null){
                    prev=parent.left;
                }
                else{
                    prev.next=parent.left;
                    prev=prev.next;
                }
                prev.next = parent.right;
                prev = prev.next;
                parent = parent.next;
                
            }
            parent=next;
            next=parent.left;
            
        }
        
        
    }
}
