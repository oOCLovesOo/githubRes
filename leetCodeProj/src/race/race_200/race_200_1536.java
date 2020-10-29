package race.race_200;

public class race_200_1536 {
    public int minSwaps(int[][] grid) {
    	int[] evryRow = new int[grid.length];
    	//1检测grid
    	for(int j=0;j<grid.length;j++) {
    		int count = 0;
	    	for(int i=grid[0].length-1;i>=0;i++) {  
	    		if(evryRow[i]==1) {
	    			break;
	    		}else {
	    			count++;
	    			evryRow[j] = count;
	    		}
	    	}
    	}
		return 0;
    }
}
