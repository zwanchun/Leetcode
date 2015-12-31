/*Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(root==null) return rst;
        Stack<TreeNode> stk=new Stack<TreeNode>();
        Stack<TreeNode> stk2=new Stack<TreeNode>();
        stk.push(root);
        int level=1;
        while(!stk.isEmpty()){
            int size=stk.size();
            List<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<size;i++){ 
               TreeNode tmp=stk.pop();
               list.add(tmp.val);
               if(level%2==1){
                   if(tmp.left!=null) stk2.push(tmp.left);
                   if(tmp.right!=null) stk2.push(tmp.right);
                   
               }
               else{
                   if(tmp.right!=null) stk2.push(tmp.right);
                   if(tmp.left!=null) stk2.push(tmp.left);
               }
            }
            Stack<TreeNode> tmpstk=stk;
            stk=stk2;
            stk2=tmpstk;
            level++;
            rst.add(list);
            
        }
        return rst;
        
    }
}
