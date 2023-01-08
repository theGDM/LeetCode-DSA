//2D dp
//TC : O(Amount * coins)
//SC : O(Amount * coins)
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for(int i = 0; i < dp.length; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        return memo(amount, 0, coins, dp);
    }
    
    public int memo(int amount, int lastCoin, int[] coins, int[][] dp){
        if(amount == 0) return dp[amount][lastCoin] = 1;
        if(dp[amount][lastCoin] != -1) return dp[amount][lastCoin];
        
        int ans = 0;
        for(int coin = lastCoin; coin < coins.length; ++coin){
            if(amount - coins[coin] >= 0){
                ans += memo(amount - coins[coin], coin, coins, dp);
            }
        }
        
        return dp[amount][lastCoin] = ans;
    }
}
