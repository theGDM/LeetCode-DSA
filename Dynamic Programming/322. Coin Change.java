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
