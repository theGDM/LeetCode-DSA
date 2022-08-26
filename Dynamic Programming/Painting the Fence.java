class Solution{
    int MOD = 1000000007;
    long countWays(int n,int k){
        long same = k * 1;//rr, bb, gg
        long diff = k * (k - 1);//rb, rg, br, bg, gr, gb
        
        if(n == 1) return k; //when only one fence is there, so there are k ways to paint it
        if(n == 2) return (same + diff) % MOD; //when only two fence is there
        
        for(int i = 3; i <= n; ++i){
            long nsame = diff;
            long total = (same + diff) % MOD;
            long ndiff = (total * (k - 1)) % MOD;
            
            same = nsame;
            diff = ndiff;
        }
        
        long ans = (same + diff) % MOD;
        return ans;
    }
}
