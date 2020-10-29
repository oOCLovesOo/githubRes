package leetCodeProj.intv;

public class RotateMatrixLCCI_01_07_02 {
    public void rotate(int[][] matrix) {
    	if(matrix==null || matrix.length==1) {
    		return;
    	}
    	int len = matrix.length;
    	int lenx = (len-1)/2;
    	for(int i=0;i<=lenx;i++) {
    		for(int j=0;j<=lenx;j++) {
    			if((len%2==1 && i==lenx && j==lenx)
    					|| (len%2==1 && i==lenx&& j==0)) {
    				break; 
    			}
    	    	int temp = matrix[i][j];
    	    	matrix[i][j] = matrix[j][len-1-i];
    	    	matrix[j][len-1-i] = temp;
    	    	
    	    	temp = matrix[i][j];
    	    	matrix[i][j] = matrix[len-1-i][len-1-j];
    	    	matrix[len-1-i][len-1-j] = temp;

    	    	temp = matrix[i][j];
    	    	matrix[i][j] = matrix[len-1-j][i];
    	    	matrix[len-1-j][i] = temp;

    		}
    	}
    }
    

    
    public static void main(String[] args) {
//    	int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    	int[][] matrix = {{1}};
    	new RotateMatrixLCCI_01_07_02().rotate(matrix);
    	for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix.length;j++) {
        		System.out.print(matrix[i][j]+"|");
        	}
        	System.out.println("");
    	}
    }
}
