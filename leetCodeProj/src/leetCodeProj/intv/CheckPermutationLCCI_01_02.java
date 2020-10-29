package leetCodeProj.intv;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutationLCCI_01_02 {
	public boolean CheckPermutation(String s1, String s2) {
		if (s1 == null || s2 == null || "".equals(s1) || "".equals(s2) || s1.length() != s2.length()) {
			return false;
		}
		Map<String, Integer> map = new HashMap<>();
		//统计第一个str
		for (int i = 0; i < s1.length(); i++) {
			if(!map.containsKey(String.valueOf(s1.charAt(i)))) {
				map.put(String.valueOf(s1.charAt(i)),1);
			}else {
				map.put(String.valueOf(s1.charAt(i)),map.get(String.valueOf(s1.charAt(i)))+1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if(!map.containsKey(String.valueOf(s2.charAt(i)                                                                                                              ))) {
				return false;
			}else {
				if(map.get(String.valueOf(s2.charAt(i)))-1>=0) {
					map.put(String.valueOf(s2.charAt(i)),map.get(String.valueOf(s2.charAt(i)))-1);
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new CheckPermutationLCCI_01_02().CheckPermutation("abcdef","fedcba"));
	}
}
