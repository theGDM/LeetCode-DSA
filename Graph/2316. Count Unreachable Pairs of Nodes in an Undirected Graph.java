//Use concept of connected component
//TC : O(V + E)
//SC : O(V + E)
class Solution {
    public static class Edge{
        int src;
        int nbr;
        
        public Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    public long countPairs(int n, int[][] edges) {
        //make the graph first
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int v = 0; v < n; ++v){
            graph[v] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int src = edge[0];
            int nbr = edge[1];
            graph[src].add(new Edge(src, nbr));
            graph[nbr].add(new Edge(nbr, src));
        }
        
        boolean[] visited = new boolean[n];
        long res = 0, remain = n; //remain -> comonent remaining to be visited
        for(int v = 0; v < n; ++v){
            if(visited[v] == false){
                int connected = getConnectedComponent(v, graph, visited);
                remain = remain - connected;
                res += connected * remain;
            }
        }
        
        return res;
    }
    
    //code for getting the connected componet
    public int getConnectedComponent(int src, ArrayList<Edge>[] graph, boolean[] visited){
        visited[src] = true;
        int ans = 0;
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                ans += getConnectedComponent(e.nbr, graph, visited);
            }
        }
        
        return ans + 1;
    }
}
