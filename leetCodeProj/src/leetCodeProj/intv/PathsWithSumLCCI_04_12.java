package leetCodeProj.intv;

import leetCodeProj.util.TreeNode;

public class PathsWithSumLCCI_04_12 {
	public int pathSum = 0;
    public int pathSum(TreeNode root, int sum) {
    	pathSum = 0;
    	if(root==null) {
    		return 0;
    	}else {
    		recursion(root,sum);
    		return pathSum;
    	}

    }
    
    public void recursion(TreeNode node, int sum) {
    	if(node==null) {
    		return;
    	}
    	recursionIn(node,sum,0);
    	if(node.left!=null) {
    		recursion(node.left,sum);
    	}
    	if(node.right!=null) {
    	  	recursion(node.right,sum);
    	}
  
    }
    
    
    public void recursionIn(TreeNode node, int sum,int nowSum) {
    	if(node==null) {
    		return;
    	}
    	nowSum+=node.val;
    	if(nowSum == sum) {
    		pathSum++;
    	}
    	
    	if(node.left!=null) {
    		recursionIn(node.left,sum,nowSum);
    	}
    	if(node.right!=null) {
    		recursionIn(node.right,sum,nowSum);
    	}
    }
    
}