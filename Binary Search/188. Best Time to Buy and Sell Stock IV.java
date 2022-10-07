//TC : O(n3)
//SC : O(kn)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][prices.length];
        
        for(int t = 0; t < k + 1; ++t){
            for(int d = 0; d < prices.length; ++d){
                if(t == 0 || d == 0){
                    dp[t][d] = 0;
                    continue;
                }
                
                int max = dp[t][d - 1];
                for(int pd = 0; pd < d; ++pd){
                    int pTillLastTran = dp[t - 1][pd]; //profit of last (t - 1) transaction on pd
                    int pOfthT = prices[d] - prices[pd];//profit of th transaction
                    
                    if(pTillLastTran + pOfthT > max){
                        max = pTillLastTran + pOfthT;
                    }
                }
                
                dp[t][d] = max;
            }
        }
        
        return dp[k][prices.length - 1];
    }
}

//Optimized 
//TC : O(n2)
//SC : O(kn)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][prices.length];
        
        for(int t = 0; t < k + 1; ++t){
            int max = Integer.MIN_VALUE;
            for(int d = 0; d < prices.length; ++d){
                if(t == 0 || d == 0){
                    dp[t][d] = 0;
                    continue;
                }
                
                if(dp[t - 1][d - 1] - prices[d - 1] > max){
                    max = dp[t - 1][d - 1] - prices[d - 1];
                }
                
                if(max + prices[d] > dp[t][d - 1]){
                    dp[t][d] = max + prices[d];
                }else{
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }
        
        return dp[k][prices.length - 1];
    }
}
