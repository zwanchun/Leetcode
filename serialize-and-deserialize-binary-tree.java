/*Serialize and Deserialize Binary Tree
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp=queue.remove();
            if(temp==null){
                sb.append(",#");
                continue;
            }
            else sb.append(","+temp.val);
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] vals=data.split(",");
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        TreeNode root=new TreeNode(Integer.parseInt(vals[1]));
        queue.add(root);
        for(int i=2;i<vals.length;i++){
            TreeNode node=queue.remove();
            if(node==null){
                i--;
                continue;
                
            }
            if(vals[i].equals("#")){
                node.left=null;
            }
            else node.left=new TreeNode(Integer.parseInt(vals[i]));
            queue.add(node.left);
            i++;
            if(i==vals.length) break;
            if(vals[i].equals("#")){
                node.right=null;
            }
            else node.right=new TreeNode(Integer.parseInt(vals[i]));
            queue.add(node.right);
        }
        return root;
        
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
