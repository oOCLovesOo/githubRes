package leetCodeProj.intv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RouteBetweenNodesLCCI_04_01 {
	Set<Integer> historyNode = new HashSet<Integer>();
	Map<Integer,List<Integer>> hashMap = new HashMap<>();
	boolean findNode = false;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
    	historyNode = new HashSet<Integer>();
    	findNode = false;
    	for(int i=0;i<graph.length;i++) {
    		if(!hashMap.containsKey(graph[i][0])) {
    			List<Integer> myList = new ArrayList<>();
    			myList.add(graph[i][1]);
    			hashMap.put(graph[i][0], myList);
    		}else {
    			hashMap.get(graph[i][0]).add(graph[i][1]);
    		}
    	}
    	this.recursion(start, target);
    	return findNode;
    }
    
    public void recursion(int begin,int target) {
    	if(findNode) {
    		return;
    	}
    	if(begin==target) {
    		this.findNode = true;
    	}
    	if(historyNode.contains(begin)) {
    		return;
    	}else {
    		historyNode.add(begin);
    	}
    	if(hashMap.get(begin)!=null) {
	    	for(Integer evryInt : hashMap.get(begin)) {
	    		this.recursion(evryInt,target);
	    	}
    	}
    }
    
    
    
	public boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {
		// 路径可达
		boolean[] dp = new boolean[n];

		for (int[] node : graph) {
			// 若出发地为start 则设置出发地到目的地可达
			dp[node[0]] = node[0] == start;
		}

		for (int[] node : graph) {
			if(dp[node[0]]) {
				if (node[1] == target) {
					return true;
				}
				dp[node[1]] = true;
			}
		}

		return dp[target];
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0,1},{1,2}};
		System.out.println(new RouteBetweenNodesLCCI_04_01().findWhetherExistsPath2(3,graph,0,2));
	}
    
}
