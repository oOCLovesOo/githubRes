package leetCodeProj.intv;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import leetCodeProj.util.ListNode;
import leetCodeProj.util.TreeNode;

public class ListOfDepthLCCI_04_03 {
    public ListNode[] listOfDepth(TreeNode tree) {
    	if(tree==null) {
    		return null;
    	}
    	List<ListNode> listListNode = new ArrayList<ListNode>();
    	Deque<TreeNode>  que = new LinkedList<TreeNode>();
    	que.add(tree);
    	while(true) {
    		int count = que.size();
    		ListNode listNode = null;
    		ListNode indexNode = null; 		
    		for(int i=0;i<count;i++) {
    			if(i==0) {
    				listNode = new ListNode(que.getFirst().val);
    				indexNode = listNode;
    			}else {
    				indexNode.next = new ListNode(que.getFirst().val);
    				indexNode = indexNode.next;
    			}
    			
        		if(que.getFirst().left!=null) {
        			que.add(que.getFirst().left);
        		}
        		if(que.getFirst().right!=null) {
        			que.add(que.getFirst().right);
        		}
        		que.pollFirst();
    		}
    		listListNode.add(listNode);
    		if(que.size()<1) {
    			break;
    		}
    		
    	}
    	
    	

    	ListNode[] res =  new ListNode[listListNode.size()];
    	for(int j=0;j<listListNode.size();j++) {
    		res[j] = listListNode.get(j);
    	}
    	return res;
    }
    
    
    public static void main(String[] args) {
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node4 = new TreeNode(4);
    	
    	node1.left = node2;
    	node1.right = node3;
    	node2.left = node4;
    	new ListOfDepthLCCI_04_03().listOfDepth(node1);
    	
    }
    
    
}
