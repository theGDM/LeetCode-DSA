class Solution {
    //keep in mind, whenever you are given with the edges array, first make the graph
    public class Edge{
        int src;
        int nbr;
        
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        //making the graph
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int v = 0; v < n; ++v){
            graph[v] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; ++i){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            
            //as we have bidirection graph
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        
        return isPath(source, destination, graph, visited);
    }
    
    public boolean isPath(int src, int dest, ArrayList<Edge>[] graph, boolean[] visited){
        if(src == dest){
            return true;
        }
        
        //preorder work
        visited[src] = true;
        
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                boolean res = isPath(e.nbr, dest, graph, visited);
                if(res == true){
                    return true;
                }
            }
        }
        
        return false;
    }
}
