package leetCodeProj.intv;

public class RotateMatrixLCCI_01_07 {
    public void rotate(int[][] matrix) {
    	for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix.length;j++) {
        		matrix[matrix.length-1-j][i] = matrix[i][j] * 2^16;//放在目标的高位 
        	}
    	}
    	for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix.length;j++) {
        		matrix[i][j] = matrix[i][j] / 2^16;//高位替换低位 
        	}
    	}
    }
    
    public static void main(String[] args) {
    	int[][] matrix ={
    		  { 5, 1, 9,11},
    		  { 2, 4, 8,10},
    		  {13, 3, 6, 7},
    		  {15,14,12,16}
    		};
    	new RotateMatrixLCCI_01_07().rotate(matrix);
    	for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix.length;j++) {
        		System.out.print(matrix[i][j]+"|");
        	}
        	System.out.println("");
    	}
    }
}
