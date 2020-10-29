package leetCodeProj.intv;

import java.util.ArrayList;
import java.util.List;

import leetCodeProj.util.ListNode;

public class KthNodeFromEndOfListLCCI_02_02 {
    public int kthToLast(ListNode head, int k) {
    	if(head.next==null) {
    		return head.val;
    	}
    	List<Integer> list = new ArrayList<Integer>();
    	ListNode nowNode = head;
    	while(true) {
    		list.add(nowNode.val);
    		if(nowNode.next!=null) {
    		 nowNode = nowNode.next;
    		}else {
    			break;
    		}
    	}
		return list.get(list.size()-k);
    }
    
    //good
    public int kthToLast2(ListNode head, int k) {
        ListNode pre = head;
        ListNode last = head;
        int i = k;
        while(pre!=null&&i!=0){
            if(i<0)
            return -1;
            pre = pre.next;
            i--;
        }
        while(pre!=null){
            pre = pre.next;
            last = last.next;
        }
        return last.val;
    }
}
