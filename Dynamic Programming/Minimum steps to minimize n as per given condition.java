class Solution{
	public int minSteps(int N) { 
	    int[] dp = new int[N + 1];
	    Arrays.fill(dp, -1);
	    return memoMinSteps(N, dp);
	} 
	
	public int memoMinSteps(int N, int[] dp){
	    if(N == 1) return dp[N] = 0;  
	    if(dp[N] != -1) return dp[N];
	    
	    int ans = Integer.MAX_VALUE;
	    if(N % 2 == 0){
	        ans = Math.min(ans, memoMinSteps(N / 2, dp));
	    }
	    
	    if(N % 3 == 0){
	        ans = Math.min(ans, memoMinSteps(N / 3, dp));
	    }
	    
	    ans = Math.min(ans, memoMinSteps(N - 1, dp));
	    
	    return dp[N] = ans + 1;
	}
}

//SC : O(N)
class Solution{
	public int minSteps(int N) { 
	    int[] dp = new int[N + 1];
	    Arrays.fill(dp, -1);
	    return memoMinSteps(N, dp);
	} 
	
	public int memoMinSteps(int N, int[] dp){
	    if(N == 1) return dp[N] = 0;
	    if(dp[N] != -1) return dp[N];
	    
	    int ans1 = (N % 2 == 0) ? memoMinSteps(N / 2, dp) : Integer.MAX_VALUE;
	    int ans2 = (N % 3 == 0) ? memoMinSteps(N / 3, dp) : Integer.MAX_VALUE;
	    int ans3 = memoMinSteps(N - 1, dp);
	    
	    return dp[N] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
	}
}
