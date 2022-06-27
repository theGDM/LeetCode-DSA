class Solution {
    public int tribonacci(int n) {
        // recursion
        // return recursion(n);
        
        // memoization
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return memoization(n, dp);
        
        // tabulation
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return tabulation(n, dp);
        
        // three variable solution TC : O(n) SC : O(1)
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
       
        int fp = 1;
        int sp = 1;
        int tp = 0;
        int curr = 0;
        
        for(int i = 3; i <= n; ++i){
            curr = fp + sp + tp;
            tp = sp;
            sp = fp;
            fp = curr;
        }
        
        return curr;
    }
    
    //TC : O(3^n) SC : O(n) recursion call stack
    public int recursion(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        
        int ans = recursion(n - 1) + recursion(n - 2) + recursion(n - 3); 
        return ans;
    }
    
    //TC : O(n) SC : O(n)
    public int memoization(int n, int[] dp){
        //base case
        if(n == 0) return dp[n] = 0;
        if(n == 1 || n == 2) return dp[n] = 1;
        
        //dictinary search
        if(dp[n] != -1){
            return dp[n];
        }
        
        int ans = memoization(n - 1, dp) + memoization(n - 2, dp) + memoization(n - 3, dp); 
        return dp[n] = ans;
    }
    
    //TC : O(n) SC : O(n)
    public int tabulation(int n, int[] dp){
        for(int i = 0; i <= n; ++i){
            if(i == 0){
                dp[i] = 0;
                continue;
            }
            
            if(i == 1 || i == 2){
                dp[i] = 1;
                continue;
            }
            
            int ans = dp[i - 1] + dp[i - 2] + dp[i - 3];
            dp[i] = ans;
        }
        
        return dp[n];
    }
}
