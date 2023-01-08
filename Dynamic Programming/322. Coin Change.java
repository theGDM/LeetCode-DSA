//Greedy Fail
class Solution {
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        Arrays.sort(coins);
        
        for(int i = coins.length - 1; i >= 0; --i){
            count += amount / coins[i];
            amount -= (amount / coins[i]) * coins[i];
            
            if(amount == 0) break;
        }
        
        if(amount > 0) return -1;
        return count;
    }
}

//recursive code
class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = helper(amount, coins);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public int helper(int amount, int[] denoms){
        if(amount == 0) return 0;
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < denoms.length; ++i){
            if(amount - denoms[i] >= 0){
                ans = Math.min(ans, helper(amount - denoms[i], denoms));
            }
        }
        
        if(ans != Integer.MAX_VALUE) return ans + 1;
        else return ans;
    }
}

//TC : O(Amount * coins.length)
//SC : O(Amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int minCoins = helper(amount, coins, dp);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    
    public int helper(int amount, int[] denoms, int[] dp){
        if(amount == 0) return dp[amount] = 0;
        if(dp[amount] != -1) return dp[amount];
        
        int minCoins = Integer.MAX_VALUE;
        for(int i = 0; i < denoms.length; ++i){
            if(amount - denoms[i] >= 0){
                minCoins = Math.min(minCoins, helper(amount - denoms[i], denoms, dp));
            }
        }
        
        if(minCoins != Integer.MAX_VALUE) return dp[amount] = minCoins + 1;
        else return dp[amount] = minCoins;
    }
}

//TC : O(Amount * coins.length)
//SC : O(Amount), DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int amt = 1; amt <= amount; ++amt){
            int minCoins = Integer.MAX_VALUE;
            for(int c = 0; c < coins.length; ++c){
                if(amt - coins[c] >= 0){
                    minCoins = Math.min(minCoins, dp[amt - coins[c]]);
                }
            }
            
            if(minCoins != Integer.MAX_VALUE) dp[amt] = minCoins + 1;
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

//2D DP Solution
//TC : O(Amount * coins.length)
//SC : O(Amount * coins)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length];
        for(int i = 0; i < dp.length; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        int minCoins = memo(amount, 0, coins, dp);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    
    public int memo(int amount, int idx, int[] coins, int[][] dp){
        if(amount == 0) return 0;
        if(idx == coins.length) return Integer.MAX_VALUE;
        
        if(dp[amount][idx] != -1) return dp[amount][idx];
        
        int minCoins = Integer.MAX_VALUE;
        for(int coin = 0; amount >= coins[idx] * coin; ++coin){
            int ans = memo(amount - coins[idx] * coin, idx + 1, coins, dp);
            if(ans != Integer.MAX_VALUE) ans += coin;
            minCoins = Math.min(minCoins, ans);
        }
        
        return dp[amount][idx] = minCoins;
    }
}
