package leetCodeProj.intv;

public class ClosedNumberLCCI_05_04 {
   public int[] findClosedNumbers(int num) {
	   if(num==Integer.MAX_VALUE || num==0) {
		   int[] a = {-1,-1};
		   return a;
	   }
	   int count = 1;
	   int numOf1 = countNum(num);
	   int lager = -2;
	   int miner = -2;
	   while(true) {
		   if(lager==-2) {
			   if(num+count>=Integer.MAX_VALUE) {
				   lager=-1;
			   }else {
				   if(countNum(num+count)==numOf1) {
					   lager = num+count;
				   } 
			   }
		   }
		   if(miner==-2) {
			   if(num-count<=0) {
				   miner = -1;
			   }else {
				   if(countNum(num-count)==numOf1) {
					   miner = num-count;
				   }
			   }

		   }
		   if(lager!=-2&&miner!=-2) {
			   break;
		   }
		   count++;
	   }
	   int[] a = {lager,miner};
	   return a;
	   
   }
   
   /**
    * 统计数字二进制情况下1的个数
    */
   public int countNum(int num) {
	   	int x = num;
	    x = (x & 0x55555555) + ((x & 0xaaaaaaaa) >> 1);  
	    x = (x & 0x33333333) + ((x & 0xcccccccc) >> 2);  
	    x = (x & 0x0f0f0f0f) + ((x & 0xf0f0f0f0) >> 4);  
	    x = (x & 0x00ff00ff) + ((x & 0xff00ff00) >> 8);  
	    x = (x & 0x0000ffff) + ((x & 0xffff0000) >> 16);
	    return x;
   }
   
   public static void main(String[] args) {
	   int[] a  = new ClosedNumberLCCI_05_04().findClosedNumbers(2);
	   System.out.println(a[0]+","+a[1]);
   }
}
