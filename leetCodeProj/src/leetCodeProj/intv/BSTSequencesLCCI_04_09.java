package leetCodeProj.intv;

import java.util.ArrayList;
import java.util.List;

import leetCodeProj.util.TreeNode;

public class BSTSequencesLCCI_04_09 {
    public List<List<Integer>> BSTSequences(TreeNode root) {
    	if(root==null) {
    		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    		resultList.add(new ArrayList<Integer>());
    		return resultList;
    	}
    	return recursion(root);
    }
    
    public List<List<Integer>> recursion(TreeNode root){
    	if(root==null) {
    		return null;
    	}
    	List<List<Integer>> leftList = recursion(root.left);
    	List<List<Integer>> rightList = recursion(root.right);	
		return this.combine(root.val, leftList, rightList);
    }
    
    
    
    public List<List<Integer>> combine(Integer faterVal,List<List<Integer>> childOne,List<List<Integer>> childTwo){
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	
    	if(childOne==null && childTwo==null) {
    		List<Integer> reTemp = new ArrayList<>();
    		reTemp.add(faterVal);
    		resultList.add(reTemp);
    	}
    	
    	if(childOne!=null) {
	    	for (List<Integer> list : childOne) {
	    		List<Integer> tempList = new ArrayList<Integer>();
	    		tempList.add(faterVal);
	    		tempList.addAll(list);
	    		if(childTwo!=null) {
		    		for (List<Integer> list2 : childTwo) {
		    			List<Integer> tempList2 = new ArrayList<Integer>();
		    			tempList2.addAll(tempList);
		    			tempList2.addAll(list2);
		    			resultList.add(tempList2);
		    		}
	    		}else {
	    			resultList.add(tempList);
	    		}
			}
    	}
    	
    	if(childTwo!=null) {
	    	for (List<Integer> list : childTwo) {
	    		List<Integer> tempList = new ArrayList<Integer>();
	    		tempList.add(faterVal);
	    		tempList.addAll(list);
	    		if(childOne!=null) {
		    		for (List<Integer> list2 : childOne) {
		    			List<Integer> tempList2 = new ArrayList<Integer>();
		    			tempList2.addAll(tempList);
		    			tempList2.addAll(list2);
		    			resultList.add(tempList2);
		    		}
	    		}else {
	    			resultList.add(tempList);
	    		}
			}
    	}
    	if(resultList.size()<1) {
    		return null;
    	}
    	return resultList;
    }
    

    
    public static void main(String[] args) {
    	TreeNode tree1 = new TreeNode(1);
    	TreeNode tree2 = new TreeNode(2);
    	tree1.left = tree2;
    	new BSTSequencesLCCI_04_09().BSTSequences(tree1);
    }
}
