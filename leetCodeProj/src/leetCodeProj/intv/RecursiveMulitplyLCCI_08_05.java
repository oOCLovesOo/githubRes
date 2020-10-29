package leetCodeProj.intv;

public class RecursiveMulitplyLCCI_08_05 {
	public int multiply(int A,int B) {
/*非递归*/
//		if(A==0||B==0) {
//			return 0;
//		}
//		int sum = 0;
//		int count=-1;
//		while(true) {
//			int remain = B%2;
//			int div = B/2;
//			count++;
//			if(remain>0) {
//				sum+=A<<count;
//			}
//			if(div==1){
//				count++;
//				sum+=A<<count;
//				break;
//			}
//			B = div;
//		}
//		
//		return sum;
/*递归方式*/
		return recursion(A,B,-1);
	}
	
	public int recursion(int A,int B,int count) {
		int temp = 0;
		int remain = B%2;
		int div = B/2;
		count++;
		if(remain>0)  {
			temp += A<<count;
		}
		if(div==1){
			count++;
			return (A<<count) + temp;
		}
		
		return recursion(A,div, count) + temp;


			
	}
	
	public static void main(String[] args) {
		System.out.println(new RecursiveMulitplyLCCI_08_05().multiply(654228,6521));
	}
}
