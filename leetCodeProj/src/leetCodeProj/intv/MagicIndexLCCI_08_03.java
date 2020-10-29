package leetCodeProj.intv;

public class MagicIndexLCCI_08_03 {
    public int findMagicIndex(int[] nums) {
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]==i) {
    			return i;
    		}
    	}
		return -1;
    }
    
    public int findMagicIndex2(int[] nums) {
    	for(int i=0;i<nums.length;) {
    		if(nums[i]==i) {
    			return i;
    		}
    		i = Math.max(nums[i], i+1);
    	}
		return -1;
    }
}
