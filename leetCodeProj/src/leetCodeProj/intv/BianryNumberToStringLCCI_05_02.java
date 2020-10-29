package leetCodeProj.intv;

public class BianryNumberToStringLCCI_05_02 {
    public String printBin(double num) {
    	if(num==0) {
    		return "0";
    	}
    	
    	if(num==1) {
    		return "ERROR";
    	}
    	if(num<0) {
    		return "ERROR";
    	}
    	String returnString = "0.";
    	while(true) {
    		double smallNum = num*2%1;
        	int intNum =(int)(num*2);
    		returnString+=intNum;
    		num=smallNum;
        	if(smallNum==0) {
        		break;
        	}
    		if(returnString.length()==32) {
    			return "ERROR";
    		}
    	}
    	
    	//尾部去0
    	while(true) {
    		if(returnString.charAt(returnString.length()-1)=='0') {
    			returnString = returnString.substring(0,returnString.length()-1);
    		}else {
    			break;
    		}
    	}
    	
    	return returnString;

    }
    
    
    public static void main(String[] agrs) {
    	System.out.println( new BianryNumberToStringLCCI_05_02().printBin(0.6));
    }
}
