package leetCodeProj.intv;

import java.util.HashMap;
import java.util.Map;

import leetCodeProj.util.ListNode;

public class IntersectionOfTwoLinkedListsLCCI_02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA==null||headB==null) {
    		return null;
    	}
        Map<Object,String> map = new HashMap<>(); 
        ListNode index = headA;
        while(index!=null) {
        	map.put(index,null);
        	index=index.next;
        }
        
        index = headB;
        while(index!=null) {
        	if(map.containsKey(index)) {
        		return index;
        	}
        	index=index.next;
        }
        
        return null;
    }
    
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode p = headA;
        ListNode q = headB;
        while(p != q){
            if(p == null){
                p = headB;
            }else{
                p = p.next;
            }
            if(q == null){
                q = headA;
            }else{
                q = q.next;
            }
        }
        
        return p;
    }
    
    
    
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    	ListNode p = headA;
    	ListNode q = headB;
    	while(p!=null||q!=null) {
    		if(p!=null) {
    			p = p.next;
    		}else {
    			p = headB;
    		}
    	
    		q = q.next;
    	}
        return p;
    }
    
    public static void main(String args[]) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	new IntersectionOfTwoLinkedListsLCCI_02_07().getIntersectionNode2(n1, n2);
    }
}
