package leetCodeProj.intv;

public class ZeroMatrixLCCI_01_08 {
    public void setZeroes(int[][] matrix) {
    	int numi[] = new int[matrix.length];
    	int numj[] = new int[ matrix[0].length];
    	int zeroArry[] = new int[matrix[0].length];
    	//水平方向是否有0
    	for(int i=0;i<matrix.length;i++) {
    		for(int j=0;j<matrix[0].length;j++) {
    			if(matrix[i][j]==0) {
    				numi[i] = 1;
    				numj[j] = 1;
    			}
    		}
    	}
    	
    	for(int i=0;i<matrix.length;i++) {
    		if(numi[i]==1) {
    			matrix[i] = zeroArry;
    		}
    		for(int j=0;j<matrix[0].length;j++) {
    			if(numj[j]==1) {
    				matrix[i][j]=0;
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {
    			  {1}
    			};
    	new ZeroMatrixLCCI_01_08().setZeroes(matrix);
    	for(int i=0;i<matrix.length;i++) {
    		for(int j=0;j<matrix[0].length;j++) {
    			System.out.print(matrix[i][j]);
    		}
    		System.out.println();
    	}
    }
}
