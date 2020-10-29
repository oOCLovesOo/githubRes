package leetCodeProj.normal;

import leetCodeProj.util.TreeNode;

public class SumOfLeftLeaves_404 {
	public int sumOfLeftLeaves(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int sum = 0;
		if(root.left!=null) {
			sum+=sumLeft(root.left,true);
		}
		if(root.right!=null) {
			sum+=sumLeft(root.right,false);
		}
		return sum;
	}
	
	public int sumLeft(TreeNode father,boolean isLeft) {
		if(father.left==null && father.right == null) {
			if(isLeft) {
				return father.val;
			}else {
				return 0;
			}
		}
		int sum = 0;
		if(father.left!=null) {
			sum+=sumLeft(father.left,true);
		}
		if(father.right!=null) {
			sum+=sumLeft(father.right,false);
		}
		
		return sum;
	}

}
