package leetCodeProj.intv;

import leetCodeProj.util.TreeNode;

public class MinimumHeightTreeLCCI_04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
    	return this.recursion(nums,0,nums.length-1,null);
    }
    
    
    public TreeNode recursion(int[] nums,int i,int j,TreeNode faterNode) {
    	if(i>j) {
    		return null;
    	}

    	if(i==j) {
    		return new TreeNode(nums[i]);
    	}
    	
    	//1.确定中心点
    	int mid = (i+j)/2;
    	TreeNode midNode = new TreeNode(nums[mid]);
    	//2.中心点左边遍历
    	midNode.left = recursion(nums,i,mid-1,midNode);
    	//3.中心点右边遍历
    	midNode.right = recursion(nums,mid+1,j,midNode);
    	return midNode;


    }
}
