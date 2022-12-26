//TC : O(N)
//SC : O(N)
class Solution{
    long mod = 1000000007;
    public long countFriendsPairings(int n) { 
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return memo(n, dp);
    }
    
    public long memo(int n, long[] dp){
        if(n == 1) return dp[n] = 1l;
        if(n == 2) return dp[n] = 2l;
        
        if(dp[n] != -1) return dp[n];
        
        long single = memo(n - 1, dp);
        long pair = ((n - 1l) * memo(n - 2, dp)) % mod;
        
        return dp[n] = (single + pair) % mod;
    }
}  
