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
