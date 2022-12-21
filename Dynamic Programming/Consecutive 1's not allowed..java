class Solution {
    //TC : O(n);
    //SC : O(n)
    public long MOD = (long)(Math.pow(10, 9) + 7);
    long countStrings(int n) {
        // code here
        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];
        
        dp0[1] = 1; //only one way of making binary string of length 1, ending with 0, i.e "0";
        dp1[1] = 1; //only one way of making binary string of length 1, ending with 1, i.e "0";
        
        for(int i = 2; i <= n; ++i){
            dp0[i] = (dp0[i - 1] + dp1[i - 1]) % MOD; //pichli bar ke binary strings jo 1 aur 0 per end ho rahi unke peeche 0 laga do
            dp1[i] = dp0[i - 1]; //pichli bar ki binary strings jo 0 per khatam ho rahi unke peeche, 1 laga do
        }
        
        long ans = (dp0[n] + dp1[n]) % MOD;
        return ans;
    }
}

class Solution {
    //TC : O(n);
    //SC : O(1);
    public long MOD = (long)(Math.pow(10, 9) + 7);
    long countStrings(int n) {
        // code here
        long zeroes = 1;
        long ones = 1;
        
        for(int i = 2; i <= n; ++i){
            long nzeroes = (zeroes + ones) % MOD;
            long nones = zeroes;
            
            zeroes = nzeroes;
            ones = nones;
        }
        
        long ans = (zeroes + ones) % MOD;
        return ans;
    }
}

//TC : O(2 * N)
//SC : O(2 * N)
class Solution {
    long mod = 1000000007;
    long countStrings(int n) {
        long[][] dp = new long[2][n + 1];
        for(int i = 0; i < 2; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(n, 0, dp);
    }
    
    long helper(int noOfDigits, int prevDigit, long[][] dp){
        if(noOfDigits == 0) {
            return dp[prevDigit][noOfDigits] = 1; //Empty string
        }
        
        if(dp[prevDigit][noOfDigits] != -1){
            return dp[prevDigit][noOfDigits];
        }
        
        long appending0 = helper(noOfDigits - 1, 0, dp);
        long appending1 = (prevDigit != 1) ? helper(noOfDigits - 1, 1, dp) : 0;
        long ans = (appending0 + appending1) % mod;
        return dp[prevDigit][noOfDigits] = ans;
    }
}
