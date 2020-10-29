package leetCodeProj.intv;

import leetCodeProj.util.ListNode;

public class SumListsLCCI_02_05 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode indexL1 = l1;
    	ListNode indexL2 = l2;
    	int mode = 0;
    	int carry = 0;
    	while(true) {
    		if(mode==0) {
    			indexL1.val = indexL1.val+indexL2.val;
    			if(carry>0) {
    				indexL1.val+=carry;
    				carry--;
    			}
    			if(indexL1.val>9) {
    				carry = 1;
    				indexL1.val-=10;
    			}
    		
    			
    			if(indexL1.next==null || indexL2.next==null) {
    				if(indexL1.next==null && indexL2.next==null) {
    					mode = 2;
    				}else if(indexL1.next!=null && indexL2.next==null){
    					indexL1 = indexL1.next;
    					mode = 1;
    				}else if(indexL1.next==null && indexL2.next!=null){
    					indexL1.next = indexL2.next;
    					indexL1 = indexL1.next;
    					mode = 1;
    				}
    			}else {
    				indexL1 = indexL1.next;
    				indexL2 = indexL2.next;
    			}
    		}
    		
    		if(mode==1) {
    			indexL1.val = indexL1.val+carry;
    			carry = 0;
    			if(indexL1.val>9) {
    				carry=1;
    				indexL1.val = indexL1.val - 10;
    			}
    			if(indexL1.next==null) {
    				if(carry>0) {
    					indexL1.next = new ListNode(1);
    				}
    				return l1;
    			}
    			indexL1 = indexL1.next;
    		}
    		
    		if(mode==2) {
    			if(carry>0) {
    				indexL1.next=new ListNode(1);
    			}
    			return l1;
    		}

    	}
    }
    
    
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int jinwei=0;
        ListNode p=new ListNode(0);
        ListNode result=p;
        while(l1!=null || l2!=null){
            int ans1=(l1==null)?0:l1.val;
            int ans2=(l2==null)?0:l2.val;
            int temp=ans1+ans2+jinwei;
            jinwei=temp/10;
            temp=temp%10;
            p.next=new ListNode(temp);
            p=p.next;
            l1=(l1==null)?l1:l1.next;
            l2=(l2==null)?l2:l2.next;
        }
        if(jinwei==1){
            p.next=new ListNode(jinwei);
            p=p.next;
        }
        return result.next;
    }
    
    public static void main(String[] args) {
    	//[8,9,9]
    	//[2]
    	ListNode node1 = new ListNode(9);
    	ListNode temp = new ListNode(8);
//    	ListNode temp2 = new ListNode(9);
    	node1.next = temp;
//    	node1.next.next = temp2;
//    	
    	
    	ListNode node2 = new ListNode(1);
//    	temp = new ListNode(2);
//    	temp2 = new ListNode(2);
//    	
//    	node2.next = temp;
//    	node2.next.next = temp2;
    	new SumListsLCCI_02_05().addTwoNumbers2(node1,node2);
    }
}
