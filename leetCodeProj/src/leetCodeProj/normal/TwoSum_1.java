package leetCodeProj.normal;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = {0,0};
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
				
				if(map.get(target - nums[i]) > i) {
					res[0] = i;
					res[1] = map.get(target - nums[i]);
				}else {
					res[0] = map.get(target - nums[i]);
					res[1] = i;
				}
				break;
			}
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int[] a = new TwoSum_1().twoSum(nums, 9);
		for(int i = 0; i < a.length;i++) {
			System.out.print(a[i] + " ");
		}
	}

}
