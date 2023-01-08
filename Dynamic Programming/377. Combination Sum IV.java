//TC : O(Amount * coins)
//SC : O(Amount)
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return helper(target, nums, dp);
    }
    
    public int helper(int amount, int[] coins, int[] dp){
        if(amount == 0) return dp[amount] = 1;
        
        if(dp[amount] != -1) return dp[amount];
        
        int ans = 0;
        for(int i = 0; i < coins.length; ++i){
            if(amount - coins[i] >= 0){
                ans += helper(amount - coins[i], coins, dp);
            }
        }
        
        return dp[amount] = ans;
    }
}
