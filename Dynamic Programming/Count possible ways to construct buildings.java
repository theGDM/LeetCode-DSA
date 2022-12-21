//TC : O(N)
//SC : O(2* N)
class Solution{
    int mod = 1000000007;
    public int TotalWays(int N){
        long[] building = new long[N + 1];
        long[] space = new long[N + 1];
        
        building[1] = 1;
        space[1] = 1;
        
        for(int i = 2; i <= N; ++i){
            building[i] = (space[i - 1]) % mod;
            space[i] = (building[i - 1] + space[i - 1]) % mod;
        }
        
        long totalArrangeMents = (building[N] + space[N]) % mod;
        totalArrangeMents = (totalArrangeMents * totalArrangeMents) % mod;
        return (int)totalArrangeMents;
    }
}
