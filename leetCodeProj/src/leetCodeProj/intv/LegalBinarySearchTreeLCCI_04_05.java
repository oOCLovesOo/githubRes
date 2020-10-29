package leetCodeProj.intv;

import leetCodeProj.util.TreeNode;

public class LegalBinarySearchTreeLCCI_04_05 {
	Boolean isFind = false;
    public boolean isValidBST(TreeNode root) {
    	isFind = false;
    	return recursion(root);
    }
    
    public boolean recursion(TreeNode node) {
    	if(isFind) {
    		return false;
    	}
    	if(node==null) {
    		return true;
    	}
    	if(!isLeftSmallRightBigger(node,0,0)) {
    		isFind=true;
    		return false;
    	}
    	return recursion(node.left) && recursion(node.right);
    }
    

    public boolean isLeftSmallRightBigger(TreeNode node,int rootVal,int rightOrLeft) {
    	if(node==null) {
    		return true;
    	}
    	
    	if(rightOrLeft==0) {
    		return isLeftSmallRightBigger(node.left,node.val,-1)&&isLeftSmallRightBigger(node.right,node.val,1);
    	}
    	
    	if(rightOrLeft==-1) {
    		if(node.val>rootVal) {
    			isFind=true;
    			return false;
    		}
    	}
    	
    	if(rightOrLeft==1) {
    		if(node.val<rootVal) {
    			isFind=true;
    			return false;
    		}
    	}
    	
		return isLeftSmallRightBigger(node.left,rootVal,rightOrLeft)&&isLeftSmallRightBigger(node.right,rootVal,rightOrLeft);
    }
    
    
    public static void main(String[] args) {
//    	TreeNode no5 = new TreeNode(5);
//    	TreeNode no1 = new TreeNode(1);
//    	TreeNode no4 = new TreeNode(4);
//    	TreeNode no3 = new TreeNode(3);
//    	TreeNode no6 = new TreeNode(6);
//    	no5.left = no1;
//    	no5.right = no4;
//    	no4.left = no3;
//    	no4.right = no6;
    	TreeNode no1 = new TreeNode(1);
    	TreeNode no2 = new TreeNode(1);
    	no1.left = no2;
    	System.out.println(new LegalBinarySearchTreeLCCI_04_05().isValidBST(no1));
    }
}
