package leetCodeProj.intv;

import leetCodeProj.util.TreeNode;

public class FirstCommonAncestorLCCI_04_08 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {// 当遍历到叶节点还没找到，返回null
			return null;
		}
		if (p == root || q == root) {// 当找到了p或者q,返回
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);// 遍历左子树
		TreeNode right = lowestCommonAncestor(root.right, p, q);// 遍历右子树
		if (left != null && right != null) {// 当作为都不为空，那么肯定是根节点
			return root;
		}
		return left == null ? right : left;// 因为p,q一定在里面，所以左为空，那么肯定在右，相反一样
	}
	
	
}
