//TC : O(N * N * N)
class Solution{
    int mod = 1000000007;
    int bellNumber(int N){
        int ans = 0;
        for(int setNum = 1; setNum <= N; ++setNum){
            int[][] dp = new int[N + 1][setNum + 1]; 
            
            //New dp array
            for(int i = 0; i < dp.length; ++i){
                Arrays.fill(dp[i], -1);
            }
            
            ans = (ans + partitionKSubset(N, setNum, dp)) % mod;
        }
        
        return ans;
    }
    
    
    public int partitionKSubset(int n, int k, int[][] dp) {
        if(n == k) return 1;
        if(n < k) return 0;
        if(k == 0) return 0;
        
        if(dp[n][k] != -1) return dp[n][k];
        
        int share = partitionKSubset(n - 1, k, dp) * k;
        int newRoom = partitionKSubset(n - 1, k - 1, dp);
        return dp[n][k] = (share + newRoom) % mod;
    }
}

//TC : O(N * N)
//SC : O(N * N)
class Solution{
    long mod = 1000000007;
    int bellNumber(int N){
        long[][] dp = new long[N + 1][N + 1];
        for(int n = 1; n <= N; ++n){
            for(int k = 1; k <= N; ++k){
                if(n < k || k == 0) continue;
                
                if(n == k) {
                    dp[n][k] = 1;
                    continue;
                }
                
                long share = (dp[n - 1][k] * k) % mod;
                long newRoom = dp[n - 1][k - 1];
                dp[n][k] = (share + newRoom) % mod;
            }
        }
        
        long res = 0;
        for(int i = 0; i < dp[0].length; ++i){
            res = (res + dp[N][i]) % mod;
        }
        
        return (int)res;
    }
}

//TC : O(N * N)
//SC : O(N * N)
class Solution{
    long mod = 1000000007;
    int bellNumber(int N){
        long[][] dp = new long[N + 1][N + 1];
        dp[0][0] = 1;
        long lastfiled = 1;
        int col = 1;
        for(int i = 1; i  <= N; ++i){
            for(int j = 0; j <= col; ++j){
                if(j == 0){
                    dp[i][j] = lastfiled;
                }else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i][j - 1]) % mod;
                    lastfiled = dp[i][j];
                }
            }
            col++;
        }
        
        return (int)dp[N][0];
    }
}
