package leetCodeProj.intv;

import leetCodeProj.util.TreeNode;

public class CheckBalanceLCCI_04_04 {
	Boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
    	if(!isBalance) {
    		return false;
    	}
        if (root == null) return true;
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
    	TreeNode no1 = new TreeNode(1);
    	TreeNode no2 = new TreeNode(2);
    	TreeNode no3 = new TreeNode(3);
    	
    	no1.right = no2;
    	no2.right = no3;
    	
    	
    	System.out.println(new CheckBalanceLCCI_04_04().isBalanced(no1));
    }
}
