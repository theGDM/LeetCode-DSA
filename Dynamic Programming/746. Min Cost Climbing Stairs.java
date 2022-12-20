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


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // memoization
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        minCostMemo(0, n, cost, dp)
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
}

//Memoization
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        minCostMemo(0, n, cost, dp);
        return Math.min(dp[0], dp[1]);
    }
    
    public int minCostMemo(int src, int n, int[] cost, int[] dp){
        if(src == n) return dp[src] = 0;
        
        if(dp[src] != -1) return dp[src];
        
        int ans1 = (src + 1 <= n) ? minCostMemo(src + 1, n, cost, dp) : 0;
        int ans2 = (src + 2 <= n) ? minCostMemo(src + 2, n, cost, dp) : 0;
        
        return dp[src] = Math.min(ans1, ans2) + cost[src];
    }
}

//Tabulation
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for(int i = n - 1; i >= 0; --i){
            int ans1 = (i + 1 <= n) ? dp[i + 1] : 0;
            int ans2 = (i + 2 <= n) ? dp[i + 2] : 0;
            dp[i] = Math.min(ans1, ans2) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = cost[n - 1];
        
        for(int i = n - 2; i >= 0; --i){
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        
        return Math.min(dp[0], dp[1]);
    }
}

//Space Optimization
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int second = 0; //with 2 jump, matlab 2 jump laga kar us index se dest tak ki min cost
        int first = cost[n - 1]; //with 1 jump, matlab 1 jump laga kar us index se dest tak ki min cost
        
        for(int i = n - 2; i >= 0; --i){
            int curr = Math.min(first, second) + cost[i];
            second = first;
            first = curr;
        }
        
        return Math.min(first, second);
    }
}
