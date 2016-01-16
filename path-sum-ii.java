/*Path Sum II
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        if(root==null) return rst;
        List<Integer> path=new ArrayList<Integer>();
        dfs(rst,path,root,sum);
        return rst;
        
    }
    
    private void dfs(List<List<Integer>> rst, List<Integer> path, TreeNode root, int sum){
        path.add(root.val);
        sum-=root.val;
        if(root.left==null&&root.right==null){
            if(sum==0){
                rst.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        if(root.left!=null){
            dfs(rst,path,root.left,sum);
            path.remove(path.size()-1);
        }
        
        if(root.right!=null){
            dfs(rst,path,root.right,sum);
            path.remove(path.size()-1);
        }
        
        
    }
}
