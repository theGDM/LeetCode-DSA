// Time: O(N * 𝐻𝑛 * α(N) + q * α(N)) ~ O(N * 𝐻𝑛 + q) ~ O(N * logN + q), where N is the number of cities, q is the number of queries.
// Explain:
// Each operation find(), union() of Union-Find costs α(N) < 5 ~ O(1). Check Time Complexity analysis at Union-Find.
// Iterate all pair of cities costs: N + N/2 + N/3 + ... + 1 = N * (1/N + 2/N + ... + 1) = N * 𝐻𝑛
// Where 𝐻𝑛 ≈ 𝑙𝑛(𝑛)+γ and γ is the famous Euler - Mascheroni constant with γ=0.57721566490153286060651209008240243104215933593992...
// So we can consider 𝐻𝑛 as O(logN) when writing complexity.

class Solution {
    int[] parent;
    int[] rank;
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        
        for(int i = 0; i < parent.length; ++i){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int div = threshold + 1; div <= n; ++div){
            for(int m = 1; m * div <= n; ++m){
                unionHelper(div, div * m);
            }
        }
        
        List<Boolean> res = new ArrayList<>();
        
        for(int[] query : queries){
            int v1 = query[0];
            int v2 = query[1];
            
            boolean ans = (find(v1) == find(v2));
            res.add(ans);
        }
        
        return res;
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void unionHelper(int x, int y){
        int xl = find(x);
        int yl = find(y);
        
        if(xl == yl){
            return;
        }
        
        if(rank[xl] < rank[yl]){
            parent[xl] = yl;
        }else if(rank[yl] < rank[xl]){
            parent[yl] = xl;
        }else{
            parent[yl] = xl;
            rank[xl]++;
        }
    }
}
