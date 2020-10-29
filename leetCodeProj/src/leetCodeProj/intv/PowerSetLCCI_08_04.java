package leetCodeProj.intv;

import java.util.ArrayList;
import java.util.List;

public class PowerSetLCCI_08_04 {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> returnList = new ArrayList<List<Integer>>();
    	returnList.add(new ArrayList<Integer>());
    	for(int i=0;i<nums.length;i++) {
    		int len = returnList.size();
    		for(int j=0;j<len;j++) {
    			List<Integer> evryList = new ArrayList<Integer>();
    			evryList.addAll(returnList.get(j));
    			evryList.add(nums[i]);
    			returnList.add(evryList);
    		}
    	}
    	return returnList;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3};
    	new PowerSetLCCI_08_04().subsets(nums);
    }
}
