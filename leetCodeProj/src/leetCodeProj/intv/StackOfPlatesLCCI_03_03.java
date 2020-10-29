package leetCodeProj.intv;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfPlatesLCCI_03_03 {
	
	class StackOfPlates {
		List<Stack<Integer>> statckList = new ArrayList<Stack<Integer>>();
		private int cap = 0;
	    public StackOfPlates(int cap) {
	    	this.cap = cap;
	    }
	    
	    public void push(int val) {
	    	if(statckList.size()>0) {
	    		
	    	}else {
	    		Stack<Integer> st = new Stack<Integer>();
	    		st.add(val);
	    		statckList.add(st);
	    	}
	    }
	    
	    public int pop() {
	    	return -1;
	    }
	    
	    public int popAt(int index) {
	    	return -1;
	    }
	}

}
