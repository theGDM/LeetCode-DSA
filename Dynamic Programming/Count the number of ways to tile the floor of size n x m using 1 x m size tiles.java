//TC : O(N)
//SC : O(N)
class Solution{
    int mod = 1000000007;
    public int countWays(int n, int m){
        int[] dp = new int[n + 1];
        return memo(n, m, dp);
    }
    
    public int memo(int n, int m, int[] dp){
        if(n < m) return 1;
        if(n == m) return 2;
        
        if(dp[n] != 0) return dp[n];
        
        int ans1 = memo(n - 1, m, dp);
        int ans2 = memo(n - m, m, dp);
        
        return dp[n] = (ans1 + ans2) % mod;
    }
}

//tabulation
class Solution{
    int mod = 1000000007;
    public int countWays(int n, int m){
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            if(i < m){
                dp[i] = 1;
                continue;
            }
            
            if(i == m){
                dp[i] = 2;
                continue;
            }
            
            dp[i] = (dp[i - 1] + dp[i - m]) % mod;
        }
        
        return dp[n];
    }
}

//space optimization
//TC : O(N)
//SC : O(M)
class Solution{
    int mod = 1000000007;
    public int countWays(int n, int m){
        ArrayDeque<Integer> dp = new ArrayDeque<>();
        if(n < m) return 1;
        if(n == m) return 2;
        
        for(int i = 1; i < m; ++i){
            dp.addLast(1);
        }
        dp.addLast(2);
        
        for(int i = m + 1; i <= n; ++i){
            int ans = (dp.getLast() + dp.getFirst()) % mod;
            dp.removeFirst();
            dp.addLast(ans);
        }
        
        return dp.getLast();
    }
}
