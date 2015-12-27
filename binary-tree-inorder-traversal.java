/*Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

//iterate
public List<Integer> inOrderIterate(TreeNode root){
		List<Integer> rst=new ArrayList<Integer>();
		Stack<TreeNode> stk=new Stack<TreeNode>();
		TreeNode curt=root;
		while(curt!=null||!stk.isEmpty()){
			while(curt!=null){
				stk.push(curt);
				curt=curt.left;
			}
			curt=stk.peek();
			stk.pop();
			rst.add(curt.val);
			curt=curt.right;
		}
		return rst;
	}
	
	//recursion
	public List<Integer> inOrderRecursion(TreeNode root){
		List<Integer> rst=new ArrayList<Integer>();
		traverseInOrder(root,rst);
		return rst;
	}
	
	private void traverseInOrder(TreeNode root, List<Integer> inorder){
		if(root==null) return;
		traverseInOrder(root.left,inorder);
		inorder.add(root.val);
		traverseInOrder(root.right,inorder);	
	}
