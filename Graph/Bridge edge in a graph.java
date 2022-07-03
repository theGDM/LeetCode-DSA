class Solution{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d){
        boolean[] vis = new boolean[V];
        int[] dis = new int[V];
        int[] low = new int[V];
        
        time = 0;
        res = 0;
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                dfs(adj, vis, dis, low, i, -1, c, d);
            }
        }
        
        return res;
    }
    
    static int time = 0;
    static int res = 0;
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] dis, int[] low, int u, int p, int c, int d){
         vis[u] = true;
         dis[u] = low[u] = ++time;
        
         for(int v : adj.get(u)){
             if(v == p){
                 //if nbr vertex of current vertex is equal to parent of current vertex
                 continue;
             }else if(vis[v] == true){
                 //visited nbr, not parent
                 //if we get any visited vertex, then we try to improve our lowest time, by its discoverd time, if its less
                 low[u] = Math.min(low[u], dis[v]);
             }else{
                 //unvisited neighbor
                 dfs(adj, vis, dis, low, v, u, c, d);
                 low[u] = Math.min(low[u], low[v]);
                 
                 if(low[v] > dis[u]){
                     //u and v forms a bridge
                    if(c == v && d == u || c == u && d == v){
                        res = 1;
                    }
                 }
             }
         }
     }
}
