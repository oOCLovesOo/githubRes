package leetCodeProj.intv;

public class CompressStringLCCI_01_06 {
    public String compressString(String S) {
    	if(S==null||S.length()==0||S.length()==1) {
    		return S;
    	}

    	int len = S.length();
    	String returnString = "";
    	char nowChar = 0;
    	int nowCount = 0;
    	for(int i=0;i<S.length();i++) {
    		if(i==0) {
    			nowChar = S.charAt(i);
    		}else if(i==S.length()-1){
    			if(nowChar != S.charAt(i)) {
    				returnString+=String.valueOf(nowChar)+nowCount;
    				nowChar = S.charAt(i);
    				returnString+=String.valueOf(nowChar)+1;
    			}else {
    				nowCount++;
    				returnString+=String.valueOf(nowChar)+nowCount;
    			}
    		}else {
    			if(nowChar != S.charAt(i)) {
    				returnString+=String.valueOf(nowChar)+nowCount;
    				nowCount = 0;
    				nowChar = S.charAt(i);
    			}
    		}
    		
			if(returnString.length()>=len) {
				return S;
			}
    		nowCount++;
    	}
    	return returnString;
    }
    
    public static void main(String[] agrs) {
    	System.out.println(new CompressStringLCCI_01_06().compressString("bb"));	
    }
}
