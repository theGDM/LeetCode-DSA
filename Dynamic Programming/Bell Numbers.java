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
        
        int sameRoom = partitionKSubset(n - 1, k, dp) * k;
        int newRoom = partitionKSubset(n - 1, k - 1, dp);
        return dp[n][k] = (sameRoom + newRoom) % mod;
    }
}
