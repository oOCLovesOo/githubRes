package leetCodeProj.intv;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetCodeProj.util.ListNode;

public class LinkedListCycleLCCI_02_08 {
    public ListNode detectCycle(ListNode head) {
    	if(head!=null&&head.next!=null&&head.next.next==head) {
    		return head;
    	}
    	
    	ListNode fast = head;
    	ListNode slow = head;
    	boolean isGet = false;
    	while(true) {
    		if(fast==null||fast.next==null||fast.next.next==null) {
    			break;
    		}
    		fast = fast.next;
    		if(!isGet) {
        		fast = fast.next;
    		}
    		slow = slow.next;
    		
    		if(fast==slow&&isGet==false) {
    			isGet = true;
    			fast = head;
    		}else if(fast==slow&&isGet==true) {
    			return fast;
    		}
    	}
 
    	head = null;
		return head;
    }
    
    
    public ListNode detectCycle2(ListNode head) {
    	if(head!=null&&head.next!=null&&head.next.next==head) {
    		return head;
    	}
    	ListNode index = head;
    	HashSet<ListNode> listNodeHashSet=new HashSet<>();
    	while(true) {
    		if(index==null||index.next==null) {
    			return null;
    		}
    		if(listNodeHashSet.contains(index)) {
    			return index;
    		}else {
    			listNodeHashSet.add(index);
    		}

    		index = index.next;
    	}
    }
    
    public ListNode detectCycle3(ListNode head) {
    	   if(head==null) return head;
           ListNode fast=head;
           ListNode slow=head;
           if(fast.next==null) return fast.next;
           slow=slow.next;
           fast=fast.next.next;
           while(slow!=null&&fast!=null){
               if(slow==fast) break;
               slow=slow.next;
               if(fast.next!=null)//要有这么个判断啊 如果下一个为空就不能走两步了 小细节哇哇哇
                   fast=fast.next.next;
               else return null;
               
           }
           
           if(fast!=null&&slow!=null){
               fast=head;
               while(fast!=slow){
                   fast=fast.next;
                   slow=slow.next;
               }
           }
           return fast;
    }
    
    public static void main(String[] args) {
        ListNode no1 = new ListNode(3);
        ListNode no2 = new ListNode(2);
        ListNode no3 = new ListNode(0);
        ListNode no4 = new ListNode(-4);	
	    no1.next = no2;
	    no2.next = no3;
	    no3.next = no4;
	    no4.next = no2;
    	
//      ListNode no1 = new ListNode(0);
//      ListNode no2 = new ListNode(1);
//      no1.next = no2;
//      no2.next = no1;

	  new LinkedListCycleLCCI_02_08().detectCycle2(no1);
    }

    
    
}
