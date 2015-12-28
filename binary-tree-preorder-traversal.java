/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?*/

//non-recursive solution
public List<Integer> preOrderIterate(TreeNode root){
		List<Integer> rst=new ArrayList<Integer>();
		Stack<TreeNode> stk=new Stack<TreeNode>();
		if(root==null) return rst;
		stk.push(root);
		while(!stk.isEmpty()){
			TreeNode tmp=stk.pop();
			rst.add(tmp.val);
			if(tmp.right!=null){
				stk.push(tmp.right);
			}
			if(tmp.left!=null){
				stk.push(tmp.left);
			}
		}
		return rst;
	}
	
	//recursive solution
	public List<Integer> preOrderRecursion(TreeNode root){
		List<Integer> rst=new ArrayList<Integer>();
		traversePreOrder(root,rst);
		return rst;
	}
	
	private void traversePreOrder(TreeNode root, List<Integer> preorder){
		if(root==null) return;
		preorder.add(root.val);
		traversePreOrder(root.left,preorder);
		traversePreOrder(root.right,preorder);
	}
