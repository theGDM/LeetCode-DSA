class Solution {
    public int fib(int n) {
        // return fiboRecursive(n);
        
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1); //fill initially with -1 value
        // return fiboMemoization(n, dp);
        
        //tabulation
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); //fill initially with -1 value
        for(int i = 0; i <= n; ++i){
            if(i == 0 || i == 1){
                dp[i] = i;
                continue;
            }
            
            int ans = dp[i - 1] + dp[i - 2];
            dp[i] = ans;
        }
        
        return dp[n];
    }
    
    //Recursive way
    //TC : O(2^n) SC : O(n) recursion call stack ka space
    public int fiboRecursive(int n){
        if(n == 0 || n == 1){
            return n;
        }
        
        int ans = fiboRecursive(n - 1) + fiboRecursive(n - 2);
        return ans;
    }
    
    //Memoization
    //TC = o(n)
    //SC = o(n) recursion call stack ka space + 1d dp array ka size
    public int fiboMemoization(int n, int[] dp){
        if(n == 0 || n == 1){
            dp[n] = n;
            return n;
        }
        
        //check query in dictionary
        if(dp[n] != -1){
            return dp[n];
        }
        
        int ans = fiboMemoization(n - 1, dp) + fiboMemoization(n - 2, dp);
        dp[n] = ans;
        return ans;
    }
    
}
