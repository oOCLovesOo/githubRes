package leetCodeProj.intv;

import java.util.Stack;

public class MinStackLCCI_03_02 {
	public MinStack ms = new MinStack();
	class MinStack {
		Stack<Integer> mainStack = null;
		Stack<Integer> assistStack = null;
		Integer nowMinVal = null; 
		
	    /** initialize your data structure here. */
	    public MinStack() {
			mainStack = new Stack<Integer>();
			assistStack = new Stack<Integer>();
	    }
	    
	    public void push(int x) {
	    	mainStack.push(x);
	    	if(nowMinVal!=null) {
	    		if(x<nowMinVal) {
	    			nowMinVal = x;
	    		}
	    		
	    	}else {
	    		nowMinVal = x;	
	    	}
	    	assistStack.push(nowMinVal);
	    }
	    
	    public void pop() {
	    	if(!mainStack.isEmpty()) {
		    	mainStack.pop();
		    	assistStack.pop();
		    	if(mainStack.isEmpty()) {
		    		nowMinVal = null;
		    	}else{
		    		nowMinVal = assistStack.peek();
		    	}
	    	}
	    }
	    
	    public int top() {
	    	if(!mainStack.isEmpty()) {
	    		return mainStack.peek();
	    	}else {
	    		return -1;
	    	}
	    }
	    
	    public int getMin() {
	    	if(!mainStack.isEmpty()) {
	    		return assistStack.peek();
	    	}else {
	    		return -1;
	    	}
	    }
	    

	}
	
	public static void main(String[] args) {
		MinStack ms = new MinStackLCCI_03_02().ms;
		ms.push(2147483646);
		ms.push(2147483646);
		ms.push(2147483647);
		ms.top();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.push(2147483647);
		ms.top();
		ms.getMin();
		ms.push(-2147483648);
		ms.top();
		ms.getMin();
		ms.pop();
		ms.getMin();
	}

}
