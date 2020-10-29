package leetCodeProj.intv;

public class StringRotationLCCI_01_09 {
    public boolean isFlipedString(String s1, String s2) {
    	if(s1==null||s2==null||s1.length()!=s2.length()) {
    		return false;
    	}
    	int num = (s1+s1).indexOf(s2);
    	if(num<0) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
    public static void main(String[] agrs) {
    	new StringRotationLCCI_01_09().isFlipedString("aba", "bab");
    }
}
