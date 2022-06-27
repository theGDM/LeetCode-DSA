class Solution {
    
    public int climbStairs(int n) {
        // recursion
        // return recursion(0, n);
        
        // memoization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoization(0, n, dp);
        
        // tabulation
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return tabulation(n, dp);
        
        // three variable solution TC : O(n) SC : O(1)
        
    }
    
    public int recursion(int idx, int n){
        if(idx == n){
            return 1;
        }
        
        int ans = 0;
        
        //1 step
        if(idx + 1 <= n){
            ans += recursion(idx + 1, n);
        }
        
        //2 step
        if(idx + 2 <= n){
            ans += recursion(idx + 2, n);
        }
        
        return ans;
    }
    
    //TC : O(n) SC : O(n)
    //there is only 1 way to go from n to n
    public int memoization(int idx, int n, int[] dp){
        if(idx == n){ //here changing variable is 1
            return dp[idx] = 1;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int ans = 0;
        
        //1 step
        if(idx + 1 <= n){
            ans += memoization(idx + 1, n, dp);
        }
        
        //2 step
        if(idx + 2 <= n){
            ans += memoization(idx + 2, n, dp);
        }
        
        return dp[idx] = ans;
    }
    
    //TC : O(n) SC : O(n)
    public int tabulation(int n, int[] dp){
        //top-down approach
        for(int idx = n; idx >= 0; --idx){
            if(idx == n){
                dp[idx] = 1;
                continue;
            }
            
            int ans = 0;
        
            //1 step
            if(idx + 1 <= n){
                ans += dp[idx + 1];
            }

            //2 step
            if(idx + 2 <= n){
                ans += dp[idx + 2];
            }

            dp[idx] = ans;
        }
        
        return dp[0];
    }
}
