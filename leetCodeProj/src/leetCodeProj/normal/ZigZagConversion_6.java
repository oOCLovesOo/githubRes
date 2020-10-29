package leetCodeProj.normal;

public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
    	if("".equals(s)||s==null||s.length()<=2||(s.length()<=numRows)||numRows<=1) {
    		return s;
    	}
    	char[] arry = s.toCharArray();
    	String retuArray = "";
    	int x = 0;
    	int n = numRows;
    	int L = 0;
    	int len = s.length();
    	while(true) {
    		retuArray +=arry[x];
    		int shu = x+2*n-2;
    		int xie = shu - 2*L;
    		if((L!=0 && L!=n-1)
    			&&(xie) < len 
    			&& (xie) > x 
    			&&  (xie) < shu) {
    			retuArray +=arry[xie];
    		}
    		if(shu < len) {
    			x = shu;
    		}else {
    			L++;
    			x=L;
    			if(L>=numRows) {
    				return retuArray;
    			}
    		}
    	}


    }
    
    public static void main(String[] args) {
    	System.out.println( new ZigZagConversion_6().convert("AB",3));
    	
    }

}
