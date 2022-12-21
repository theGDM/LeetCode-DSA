//TC : o(N)
class Solution {
    static long mod = 1000000007;
    static Long numberOfWays(long n) {
        if(n == 0 || n == 1 || n == 2) return n;
        
        long ans1 = numberOfWays(n - 1);
        long ans2 = numberOfWays(n - 2);
        
        return (ans1 + ans2) % mod;
    }
};

//TC : o(N)
class Solution {
    static long mod = 1000000007;
    static Long numberOfWays(int n) {
        long[] dp = new long[n + 1];
        return memo(n, dp);
    }
    
    public static long memo(int n, long[] dp){
        if(n == 0 || n == 1 || n == 2) return dp[n] = n;
        if(dp[n] != 0) return dp[n];
        long ans1 = memo(n - 1, dp);
        long ans2 = memo(n - 2, dp);
        
        return dp[n] = (ans1 + ans2) % mod;
    }
};

//TC : o(N)
class Solution {
    static long mod = 1000000007;
    static Long numberOfWays(int n) {
        //edge case
        if(n == 0 || n == 1) return (long)n;
        
        long[] dp = new long[n + 1];
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
        
        //fibonacci sequence
        for(int i = 3; i <= n; ++i){
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        
        return dp[n];
    }
};
