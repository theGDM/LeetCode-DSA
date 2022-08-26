class Solution {
    int MOD = 1000000007;
    public int countHousePlacements(int n) {
        long[] house = new long[n + 1];
        long[] space = new long[n + 1];
        
        house[1] = 1;
        space[1] = 1;
        
        for(int i = 2; i <= n; ++i){
            house[i] = space[i - 1]; //pichle space ke peeche house bana do, as no adjacent house are allowed
            space[i] = (space[i - 1] + house[i - 1]) % MOD; //pichele house aur space ke peeche space laga do
        }
        
        long total = (house[n] + space[n]) % MOD;
        long ans = (total * total) % MOD; //toatl arrangement on both side
        
        return (int)ans;
    }
}
