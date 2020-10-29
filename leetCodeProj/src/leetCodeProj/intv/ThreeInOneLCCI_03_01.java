package leetCodeProj.intv;

public class ThreeInOneLCCI_03_01 {
	TripleInOne tio = null;
	public ThreeInOneLCCI_03_01(int num) {
		this.tio = new TripleInOne(num);
	}
	
	
	class TripleInOne {
		/**
		 各栈对应下标
		 	0		~		size-1
		 	size	~		2*size-1
		 	size*2	~		3*size-1
		 */
		
		private int stackSize = -1;
		private int[]stackVal = null;
		private int[]evryStackIndex = null;
	    public TripleInOne(int stackSize) {
	    	this.stackSize = stackSize;
	    	stackVal = new int[stackSize*3];
	    	evryStackIndex = new int[3];
	    	evryStackIndex[0] = 0;
	    	evryStackIndex[1] = stackSize;
	    	evryStackIndex[2] = stackSize*2;
	    }
	    
	    public void push(int stackNum, int value) {
	    	if(evryStackIndex[stackNum]<=(stackNum+1)*this.stackSize-1) {
	    		stackVal[evryStackIndex[stackNum]] = value;
	    		evryStackIndex[stackNum] = evryStackIndex[stackNum]+1;
	    	}
	    }
	    
	    public int pop(int stackNum) {
	    	if(this.isEmpty(stackNum)) {
	    		return -1;
	    	}else {
	    		evryStackIndex[stackNum] = evryStackIndex[stackNum] - 1;
	    		return stackVal[evryStackIndex[stackNum]];
	    	}
	    }
	    
	    public int peek(int stackNum) {
	    	if(this.isEmpty(stackNum)) {
	    		return -1;
	    	}else {
	    		return stackVal[evryStackIndex[stackNum]-1];
	    	}
	    }
	    
	    public boolean isEmpty(int stackNum) {
	    	if((evryStackIndex[stackNum]-this.stackSize*stackNum)==0) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    	
	    }
	}
	
	
	public static void main(String[] args) {
		TripleInOne tio = new ThreeInOneLCCI_03_01(1).tio;
		tio.push(0, 1);
		tio.push(0, 2);
		tio.pop(0);
		tio.pop(0);
	}

}
