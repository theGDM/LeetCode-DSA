//TC : O(N * (2 * Primes.length)) 
//SC : O(N) dp array + O(Primes.length) ptr array
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ptr = new int[primes.length];
        Arrays.fill(ptr, 1);
        
        long[] dp = new long[n + 1];
        dp[1] = 1;//add first ugly number at index 1
        
        for(int i = 2; i <= n; ++i){
            long min = Long.MAX_VALUE;
            for(int j = 0; j < primes.length; ++j){
                min = Math.min(min, dp[ptr[j]] * primes[j] * 1l);
            }
            
            //updating all pointers having min value
            for(int j = 0; j < primes.length; ++j){
                if(min == dp[ptr[j]] * primes[j] * 1l) ptr[j]++;
            }
            
            dp[i] = min;
        }
        
        return (int)dp[n];
    }
}
