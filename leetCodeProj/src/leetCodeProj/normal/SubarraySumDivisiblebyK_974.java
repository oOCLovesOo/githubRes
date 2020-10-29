package leetCodeProj.normal;

public class SubarraySumDivisiblebyK_974 {
		public static int subarrayDivByK(int[] A,int K){
			if(A.length==1) {
				return A[0]%K==0?1:0;
			}
			int[] myK = new int[K];
			myK[0]=1;
			int sum = 0;
			int length = 0;
			for(int i = 1;i<A.length+1;i++) {
				sum = sum + A[i-1];
				myK[sum%K]+=1;
			}
			for(int i=0;i<myK.length;i++){
				if(myK[i]==2) {
					length+=1;
				}else {
					length+= factorial(myK[i])/(factorial(2)*factorial(myK[i]-2));
				}
//				length += (myK[i]==2?2:factorial(myK[i])/(factorial(2)*factorial(myK[i]-2)))
			};
			return length;
		}
		
		public static int factorial(int n) {
			if(n<0||n==1) {
				return n;
			}
			int t = 1;
			while(n>0) {
				t*=n;
				n--;
			}
			return t;
		}
		
		public int cMn(int m,int n) {
			return this.factorial(m)/(this.factorial(n)*this.factorial(m-n));
		}
	
		public static void main(String[] args) {
			int[] A = {4,5,0,-2,-3,1};
			System.out.print(subarrayDivByK(A,5));
		}
}
