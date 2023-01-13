//TC : O(N * N)
//SC : O(N)
//Memoization
class Solution{
    public int cutRod(int price[], int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memo(n, price, dp);
    }
    
    public int memo(int len, int[] price, int[] dp){
        if(len == 0) return dp[len] = 0;
        if(dp[len] != -1) return dp[len];
        int ans = -1;
        for(int cutLen = 1; cutLen <= price.length; ++cutLen){
            if(len - cutLen >= 0){
                ans = Math.max(ans, memo(len - cutLen, price, dp) + price[cutLen - 1]);
            }
        }
        
        return dp[len] = ans;
    }
}
