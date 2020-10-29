package leetCodeProj.intv;

public class ThreeStepsProblemLCCI_08_01 {
    public int waysToStep(int n) {
    	switch(n) {
			case 1:return 1;
			case 2:return 2;
			case 3:return 4;
		}
    	long dp[] = new long[n+1];
    	dp[1] = 1;
    	dp[2] = 2;
    	dp[3] = 4;
    	for(int i=4;i<=n;i++) {
    		dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000007;
    	}
		return (int)dp[n];
    }
    
    //此方法超时
    public int fn(int n) {
    	switch(n) {
			case 1:return 1;
			case 2:return 2;
			case 3:return 4;
		}
    	return fn(n-1)+fn(n-2)+fn(n-3);
    }
}
