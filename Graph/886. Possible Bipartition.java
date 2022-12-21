class Solution {
    public class Edge{
        int src;
        int nbr;
        
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
        
        public String toString() {
            return "[" + this.src + ", " + this.nbr + "]";
        }
    }
    
    public class Pair{
        int src;
        int lvl;
        
        Pair(int src, int lvl){
            this.src = src;
            this.lvl = lvl;
        }
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //making the graph initially
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; ++i){
            graph[i] = new ArrayList<>();
        }
        
        //Time complexity for creating graph O(N) + O(E), E is edge length, here dislikes array length
        for(int[] pair : dislikes){
            int p1 = pair[0];
            int p2 = pair[1];
            
            graph[p1].add(new Edge(p1, p2));
            graph[p2].add(new Edge(p2, p1));
        }
        
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1); //mark unvisited via -1
        
        for(int v = 1; v <= n; ++v){
            if(visited[v] == -1){
                boolean isCompBipartite = checkCompBipartite(v, graph, visited);
                //if any of the component of the graph is not bipartite, then whole graph is not bipartite!
                if(isCompBipartite == false){
                   return false;
                }
            }
        }
        return true;
    }
    
    //O(N + E)
    public boolean checkCompBipartite(int src, ArrayList<Edge>[] graph, int[] visited){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));
        
        while(q.size() > 0){
            Pair rem = q.remove();
            
            if(visited[rem.src] != -1){
                if(rem.lvl != visited[rem.src]){
                    return false;
                }
            }
            
            visited[rem.src] = rem.lvl;
            for(Edge e : graph[rem.src]){
                if(visited[e.nbr] == -1){
                    q.add(new Pair(e.nbr, rem.lvl + 1));
                }
            }
        }
        
        return true;
    }
}
