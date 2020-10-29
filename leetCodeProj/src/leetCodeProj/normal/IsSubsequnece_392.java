package leetCodeProj.normal;

public class IsSubsequnece_392 {
	public boolean isSubsequence(String s,String t) {
		if("".equals(s)) {
			return true;
		}
		if("".equals(t)) {
			return false;
		}
		int i = 0;
		int j = 0;
		while(i<s.length()) {
			if(t.charAt(i)==s.charAt(j)) {
				j++;
			}
			if(j==s.length()) {
				return true;
			}
			i++;
		}
		return false;
	}
}
