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
