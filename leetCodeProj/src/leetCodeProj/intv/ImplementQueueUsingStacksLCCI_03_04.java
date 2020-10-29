package leetCodeProj.intv;

import java.util.Stack;

public class ImplementQueueUsingStacksLCCI_03_04 {
	
	class MyQueue {
		Stack<Integer> stack1 = null;
		Stack<Integer> stack2 = null;

	    public MyQueue() {
			stack1 = new Stack<Integer>();
			stack2 = new Stack<Integer>();
	    }
	    
	    public void push(int x) {
	    	stack1.push(x);
	    }
	    
	    public int pop() {
	    	if(empty()) {
	    		return -1;
	    	}else {
	    		if(stack2.isEmpty()) {
	    			while(!stack1.isEmpty()) {
	    				stack2.push(stack1.pop());
	    				
	    			}
	    		}
	    		if(!stack2.isEmpty()) {
	    			return stack2.pop();
	    		}
	    		
	    	}
	    	return -1;
	    }
	    
	    public int peek() {
	    	if(empty()) {
	    		return -1;
	    	}else {
	    		if(stack2.isEmpty()) {
	    			while(!stack1.isEmpty()) {
	    				stack2.push(stack1.pop());
	    				
	    			}
	    		}
	    		if(!stack2.isEmpty()) {
	    			return stack2.peek();
	    		}
	    		
	    	}
	    	return -1;
	    }
	    
	    public boolean empty() {
	    	if(stack1.isEmpty()&&stack2.isEmpty()) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    }
	}
}
