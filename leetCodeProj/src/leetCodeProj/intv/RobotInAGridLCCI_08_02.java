package leetCodeProj.intv;

import java.util.ArrayList;
import java.util.List;

public class RobotInAGridLCCI_08_02 {
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
    	//dp数组
    	List[][] listArray = new List[obstacleGrid.length][obstacleGrid[0].length];
    	//递推
    	for(int i=0;i<obstacleGrid.length;i++) {
    		for(int j=0;j<obstacleGrid[0].length;j++) {
				if(i==0&&j==0) {
					if(obstacleGrid[0][0]==1) {
//						List<Integer> returnList = new ArrayList<Integer>();
						List<List<Integer>> returnListList = new ArrayList<List<Integer>>();
//						returnListList.add(returnList);
						return returnListList;
					}else {
						List<Integer> pointList = new ArrayList<Integer>();
						pointList.add(0);
						pointList.add(0);
						List<List<Integer>> evryPointList = new ArrayList<List<Integer>>();
						evryPointList.add(pointList);
						listArray[0][0] = evryPointList;
						obstacleGrid[0][0]=2;
					}
					continue;
				}
				
    			//左看
    			if(j-1>=0) {
    				if(obstacleGrid[i][j]!=1 && obstacleGrid[i][j-1]==2) {
    					List<List<Integer>> evryPointList = new ArrayList<List<Integer>>();
       					evryPointList.addAll(listArray[i][j-1]);
    					List<Integer> pointList = new ArrayList<Integer>();
						pointList.add(i);
						pointList.add(j);
    					evryPointList.add(pointList);
    					listArray[i][j]=evryPointList;
       					obstacleGrid[i][j]=2;
    					continue;
    				}
    			}
				
				//上看
    			if(i-1>=0) {
    				if(obstacleGrid[i][j]!=1 && obstacleGrid[i-1][j]==2) {
    					List<List<Integer>> evryPointList = new ArrayList<List<Integer>>();
    					evryPointList.addAll(listArray[i-1][j]);
    					List<Integer> pointList = new ArrayList<Integer>();
						pointList.add(i);
						pointList.add(j);
    					evryPointList.add(pointList);
    					listArray[i][j]=evryPointList;
    					obstacleGrid[i][j]=2;
    					continue;
    				}
    			}
    		}
    	}
    	if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==2) {
    		return listArray[obstacleGrid.length-1][obstacleGrid[0].length-1];
    	}else {
			List<Integer> returnList = new ArrayList<Integer>();
			List<List<Integer>> returnListList = new ArrayList<List<Integer>>();
			returnListList.add(returnList);
			return returnListList;
    	}

    }
    
    public static void main(String[] agrs) {
    	int[][] map = {
    			  {0,0,0},
    			  {0,1,0},
    			  {0,0,0}
    			};
    	new RobotInAGridLCCI_08_02().pathWithObstacles(map);
    }
}
