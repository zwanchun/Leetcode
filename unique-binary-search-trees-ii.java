/*Unique Binary Search Trees II
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

/*solution:
根据前面我们知道，对于在n里面的任意i，它的排列数为左子树[0, i - 1]的排列数 x 右子树[i + 1, n]的排列数，所以我们只需要得到i的左子树和右子树的所有排列，就能得到i的所有排列了。而这个使用递归就能搞定
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
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList<TreeNode>();
        return generateTrees(1,n);
        
    }
    
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> rst=new ArrayList<TreeNode>();
        
        if(start>end){
            rst.add(null);
            return rst;
        }
        
        for(int i=start;i<=end;i++){
            List<TreeNode> left=generateTrees(start,i-1);
            List<TreeNode> right=generateTrees(i+1,end);
            for(TreeNode l: left){
                for(TreeNode r: right){
// should new a root here because it need to 
// be different for each tree
                    TreeNode root = new TreeNode(i);  
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
            
        }
        return rst;
    }
}
