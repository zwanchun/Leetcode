/*Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst=new ArrayList<Integer>();
        Stack<TreeNode> stk=new Stack<TreeNode>();
        if(root==null) return rst;
        TreeNode prev=null;
        TreeNode curr=root;
        stk.push(root);
        while(!stk.isEmpty()){
            curr=stk.peek();
            if(prev==null||prev.left==curr||prev.right==curr){//traverse down the tree
                if(curr.left!=null){
                    stk.push(curr.left);
                }
                else if(curr.right!=null){
                    stk.push(curr.right);
                }
            }
            else if(curr.left==prev){//traverse up the tree from the left
                if(curr.right!=null){
                    stk.push(curr.right);
                }
                
            }
            else{//traverse up the tree from the right
                rst.add(curr.val);
                stk.pop();
            }
            prev=curr;
            
            
        }
        return rst;
        
        
        
    }
}
