package leetCodeProj.intv;

import java.util.Stack;

import leetCodeProj.util.TreeNode;

public class SuccessorLCCI_04_06 {
	Stack<TreeNode> nodeStack = new Stack<TreeNode>();
	Boolean isFind = false;
	TreeNode targetNode = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	isFind = false;
    	targetNode = null;
    	nodeStack = new Stack<TreeNode>();
    	if(p==null||root==null) {
    		return null;
    	}
    	if(p.right==null) {
    		recursion(root, p);
    		if(isFind&&targetNode!=null) {
    			return targetNode;
    		}else {
    			return null;
    		}
    	}else {
    		//找右子树中序第一个
    		findFirst(p.right);
    		if(isFind&&targetNode!=null) {
    			return targetNode;
    		}else {
    			return null;
    		}
    	}
    }
    
    
    public void recursion(TreeNode pNode,TreeNode p) {
    	if(isFind) {
    		return;
    	}
    	if(pNode==p) {
    		isFind = true;
    		if(nodeStack.size()>0 && nodeStack.peek()!=null) {
    			targetNode = nodeStack.peek();
    		}
    	}
    	if(pNode.left!=null) {
    		nodeStack.push(pNode);
    		recursion(pNode.left,p);	
        	nodeStack.pop();
    	}

    	if(isFind) {
    		return;
    	}
    	if(pNode.right!=null) {
    		recursion(pNode.right,p);
    	}
    }
    
    public void findFirst(TreeNode node) {
    	if(isFind||node==null) {
    		return;
    	}
    	if(node.left==null) {
    		isFind = true;
    		targetNode = node;
    		return;
    	}
    	findFirst(node.left);
    	if(isFind) {
    		return;
    	}
    	findFirst(node.right);
    }
    
    public static void main(String[] args) {
    	TreeNode no5 = new TreeNode(5);
    	TreeNode no3 = new TreeNode(3);
    	TreeNode no6 = new TreeNode(6);
    	TreeNode no1 = new TreeNode(1);
    	TreeNode no4 = new TreeNode(4);
    	TreeNode no2 = new TreeNode(2);
    	no5.left = no3;
    	no5.right = no6;
    	no3.left = no1;
    	no3.right = no4;
    	no6.left = no2;
    	
    	System.out.println(new SuccessorLCCI_04_06().inorderSuccessor(no5,no4).val);
    }
}
