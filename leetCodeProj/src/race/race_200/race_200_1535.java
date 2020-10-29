package race.race_200;

import java.util.LinkedList;

public class race_200_1535 {
    public int getWinner(int[] arr, int k) {
    	int maxNum = -1;
    	LinkedList<Integer> linkedList = new LinkedList<Integer>();
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]>maxNum) {
    			maxNum = arr[i];
    		}
    		linkedList.add(arr[i]);
    	}
    	int nowWinner = -1;
    	int winCount = 0;
    	while(true) {
    		if(maxNum==linkedList.getFirst()) {
    			return maxNum;
    		}
    		int first = linkedList.get(0);
    		int second = linkedList.get(1);
    		if(first<second) {
    			if(second==nowWinner) {
    				winCount++;
    			}else {
    				winCount=1;
    			}
    			nowWinner = second;
    			linkedList.addLast(linkedList.removeFirst());
    		}else {
    			if(first==nowWinner) {
    				winCount++;
    			}else {
    				winCount=1;
    			}
    			nowWinner = first;
    			linkedList.addLast(linkedList.remove(1));
    		}
    		if(winCount==k) {
    			return nowWinner;
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int[] a = {1,11,22,33,44,55,66,77,88,99};
    	System.out.println(new race_200_1535().getWinner(a,1000000000));
    }
}
