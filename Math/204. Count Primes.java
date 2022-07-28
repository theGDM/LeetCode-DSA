//sieve of eratosthene
//TC : O(nlog(logn))
class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;
        
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        
        primes[0] = false;
        primes[1] = false;
        
        for(int tbl = 2; tbl * tbl <= n; ++tbl){
            if(primes[tbl] == false) continue;
            
            for(int m = tbl; tbl * m <= n; ++m){
                primes[tbl * m] = false;
            }
        }
        
        int res = 0;
        for(int i = 2; i < n; ++i){
            if(primes[i] == true) res++;
        }
        
        return res;
    }
}
