class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int n = cost.length;
        // return Math.min(minCost(0, n, cost), minCost(1, n, cost));
        
        // memoization
        // int n = cost.length;
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return Math.min(minCostMemo(0, n, cost, dp), dp[1]);
           
        // tabulation
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        for(int idx = n; idx >= 0; --idx){
            if(idx == n){
                dp[idx] = 0;
                continue;
            }
            
            int ans = Integer.MAX_VALUE;
            if(idx + 1 <= n){ //jump 1
                ans = Math.min(ans, dp[idx + 1]);
            }

            if(idx + 2 <= n){ //jump 2
                ans = Math.min(ans, dp[idx + 2]);
            }
            
            int res = ans + cost[idx]; //current index se aange jane ki cost add
            dp[idx] = res;
        }
        
        return Math.min(dp[0], dp[1]);
    }
    
    public int minCostMemo(int idx, int n, int[] cost, int[] dp){
        if(idx == n){ //base case : cost of moving from n to n is 0
            return dp[idx] = 0;
        }
    
        //check in dictionary
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int ans = Integer.MAX_VALUE;
        if(idx + 1 <= n){ //jump 1
            ans = Math.min(ans, minCostMemo(idx + 1, n, cost, dp));
        }
        
        if(idx + 2 <= n){ //jump 2
            ans = Math.min(ans, minCostMemo(idx + 2, n, cost, dp));
        }
        
        int res = ans + cost[idx]; //current index se aange jane ki cost add
        return dp[idx] = res;
    }
    
    public int minCost(int idx, int n, int[] cost){
        if(idx == n){ //base case : cost of moving from n to n is 0
            return 0;
        }
    
        int ans = Integer.MAX_VALUE;
        if(idx + 1 <= n){ //jump 1
            ans = Math.min(ans, minCost(idx + 1, n, cost));
        }
        
        if(idx + 2 <= n){ //jump 2
            ans = Math.min(ans, minCost(idx + 2, n, cost));
        }
        
        int res = ans + cost[idx]; //current index se aange jane ki cost add
        return res;
    }
}
