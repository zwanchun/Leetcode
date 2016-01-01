/*Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
*/

/*solution:判断最左叶节点和最右叶节点是否高度一样，是则直接求节点个数，否则分别递归入两个子节点。
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
    public int countNodes(TreeNode root) {
       if(root==null) return 0;
       int lnod=0,rnod=0;
       lnod=countLeft(root);
       rnod=countRight(root);
       if(lnod==rnod){
           return (1<<lnod)-1;
       }
       return 1+countNodes(root.left)+countNodes(root.right);
       
        
    }
    
    private int countLeft(TreeNode root){
        int count=0;
        while(root!=null){
            root=root.left;
            count++;
        }
        return count;
    }
    
    private int countRight(TreeNode root){
        int count=0;
        while(root!=null){
            root=root.right;
            count++;
        }
        return count;
        
    }
}
