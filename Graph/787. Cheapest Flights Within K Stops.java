//TC : k.edges = k*m
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] d = new int[n];
        
        Arrays.fill(d, Integer.MAX_VALUE);
        
        d[src] = 0; //a -> a tak jaane ka min cost obviously 0
        
        for(int i = 1; i <= k + 1; ++i){ //K + 1, covers K + 1 edges and k stops
            int[] D = d.clone(); //copy of values of d
            for(int[] route : flights){
                int u = route[0];
                int v = route[1];
                int routeCharge = route[2];
                
                if(d[u] != Integer.MAX_VALUE){
                    int cost = d[u] + routeCharge;
                    if(cost < D[v]){
                        D[v] = cost;
                    }
                }
            }
            
            d = D; //d start referencing to D
        }
        
        if(d[dst] !=  Integer.MAX_VALUE){
            return d[dst];
        }else{
            return -1;
        }
    }
}
