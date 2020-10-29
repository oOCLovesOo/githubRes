package leetCodeProj.intv;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SortOfStacksLCCI_03_05 {
	class SortedStack {
		Stack<Integer> mainStack = null;
		Stack<Integer> secondStack = null;

	    public SortedStack() {
			this.mainStack = new Stack<Integer>();
			this.secondStack = new Stack<Integer>();
	    }
	    
	    public void push(int val) {
    		while(!this.isEmpty() && val > mainStack.peek()) {
    			secondStack.push(mainStack.pop());
    		}
    		mainStack.push(val);
    		while(!secondStack.isEmpty()) {
    			mainStack.push(secondStack.pop());
    		}
	    }
	    
	    public void pop() {
	    	if(!this.isEmpty()) {
	    		mainStack.pop();
	    	}
	    }
	    
	    public int peek() {
	    	if(!this.isEmpty()) {
	    		return mainStack.peek();
	    	}else {
	    		return -1;
	    	}
	    }
	    
	    public boolean isEmpty() {
	    	return mainStack.isEmpty();
	    }
	}
	
	
	
	class SortedStack2 {

	    Deque<Integer> help=new LinkedList<>();
	    Deque<Integer> stack=new LinkedList<>();
	    public SortedStack2() {

	    }
	    
	    public void push(int val) {
	        int s_top=stack.isEmpty()?Integer.MAX_VALUE:stack.peek();
	        int h_top=help.isEmpty()?Integer.MIN_VALUE:help.peek();
	        while(!stack.isEmpty()&&val>s_top)
	        {
	            help.push(stack.pop());
	            s_top=stack.isEmpty()?Integer.MAX_VALUE:stack.peek();
	        }
	        while(!help.isEmpty()&&val<h_top)
	        {
	            stack.push(help.pop());
	            h_top=help.isEmpty()?Integer.MIN_VALUE:help.peek();
	        }
	        stack.push(val);
	        
	    }
	    
	    public void pop() {
	        while(!help.isEmpty())
	        stack.push(help.pop());
	        if(!stack.isEmpty()) stack.pop();
	    }
	    
	    public int peek() {
	        if(!help.isEmpty())
	        return help.getLast();
	        else if(!stack.isEmpty())
	        return stack.peek();
	        else return -1;
	    }
	    
	    public boolean isEmpty() {
	        return help.isEmpty()&&stack.isEmpty();
	    }
	}
	
	
	public static void main(String[] args) {
		Deque<Integer> help=new LinkedList<>();
		help.add(1);
		help.add(2);
		System.out.println(help.getFirst());
		System.out.println(help.getFirst());
		System.out.println(help.pollFirst());
		System.out.println(help.getFirst());
		
	}

}
