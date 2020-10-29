package leetCodeProj.intv;

import leetCodeProj.util.TreeNode;

public class CheckSubTreeLCCI_04_10 {
	public TreeNode findNode = null;
	public boolean isSame = true;
	public boolean checkSubTree(TreeNode t1, TreeNode t2) {
		findNode = null;
		isSame = true;
		recursion(t1, t2);
		if(findNode==null){
			if(t2==null) {
				return true;
			}else {
				return false;
			}
		}else {
			recursion2(findNode,t2);
			return isSame;
		}
	}

	public void recursion(TreeNode node, TreeNode target) {
		if (node == null || findNode!=null) {
			return;
		}

		if (node.val == target.val) {
			findNode = node;
		}

		recursion(node.left, target);
		recursion(node.right, target);
	}
	
	public void recursion2(TreeNode node, TreeNode target) {
		if(isSame==false) {
			return;
		}
		
		if(node==null || target==null) {
			if(node!=target) {
				isSame=false;
			}
			return;
		}
		if(node.val!=target.val) {
			isSame = false;
			return;
		}
		recursion(node.left, target.left);
		recursion(node.right, target.right);
	}

	public static void main(String[] args) {
		// TreeNode no1 = new TreeNode(1);
		// TreeNode no2 = new TreeNode(2);
		// TreeNode no3 = new TreeNode(3);
		// no1.left = no2;
		// no1.right = no3;
		//
		// System.out.println(new CheckSubTreeLCCI_04_10().checkSubTree(no1, no2));
	}
}
