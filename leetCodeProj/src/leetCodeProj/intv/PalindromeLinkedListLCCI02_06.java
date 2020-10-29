package leetCodeProj.intv;

import java.util.ArrayList;
import java.util.List;

import leetCodeProj.util.ListNode;

public class PalindromeLinkedListLCCI02_06 {
    public boolean isPalindrome(ListNode head) {
    	if(head==null||head.next==null) {
    		return true;
    	}
    	List<Integer> allList = new ArrayList<Integer>();
    	ListNode indexNode = head;
    	while(true) {
    		allList.add(indexNode.val);
    		indexNode = indexNode.next;
    		if(indexNode==null) {
    			break;
    		}
    	}
    	for(int i =0 ;i<=(allList.size()-1)/2;i++) {
    		if(!allList.get(i).equals(allList.get(allList.size()-1-i))) {
    			return false;
    		}
    	}
		return true;
    }
    
    
    
//    public boolean isPalindrome2(ListNode head) {
//    }
//    
    public static void main(String[] args) {
    	ListNode head = new ListNode(-129);
    	head.next = new ListNode(-129);
    	new PalindromeLinkedListLCCI02_06().isPalindrome(head);
    }
}
