package leetCodeProj.intv;

public class ReverseBitsLCCI_05_03 {
    public int reverseBits(int num) {
    	if(num==1||num==0) {
    		return num;
    	}
    	int count = 0;
    	int preCount = 0;
    	int maxNum = 0;
    	int nowZeroCount = 0;
    	
//    	StringBuffer sb = new StringBuffer();
    	while(true) {
    		int remain = num%2;//取余数
    		int divd = num/2;//取除数
    		num = divd;
//    		sb.append(remain);
    		//
    		if(remain==1) {
    			count++;
    		}else {
    			nowZeroCount++;
    			if(nowZeroCount==1) {//首次遇0
    				if(count+1>maxNum) {
    					maxNum = count + 1;
    				}
    			}else if(count!=0){//0夹多个1情况
    				if(count+preCount+1>maxNum) {
    					maxNum = count+preCount+1;
    				}
    				nowZeroCount--;
    			}else {
    				nowZeroCount=0;
    			}
				preCount = count;
				count = 0;
    		}
    		//
    		if(num==1) {
    			count++;
    			nowZeroCount++;
    			if(nowZeroCount==1) {//首次遇0
    				if(count+1>maxNum) {
    					maxNum = count + 1;
    				}
    			}else if(count!=0){//0夹多个1情况
    				if(count+preCount+1>maxNum) {
    					maxNum = count+preCount+1;
    				}
    				nowZeroCount--;
    			}else {
    				nowZeroCount=0;
    			}
				preCount = count;
				count = 0;
//    			sb.append(1);
//    			System.out.println(sb);
    			break;
    		}
    		

    	}
    	return maxNum;
    }
    
    
    
    public static void main(String[] args) {
    	System.out.println( new ReverseBitsLCCI_05_03().reverseBits(2147482622));
    }
}
