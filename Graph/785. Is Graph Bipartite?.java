//BFS
//here 0 means -> uncolored vertices, Bipartite means if we can divide the vertices of the graph in two mutually exclusive and mutually exhaustive sets. 
//(+1) -> red
//(-1) -> green
//So parent vertices will always try to send its nbrs vertex in other set(so we mark with the opposite color of parent vertex)
//if any how, at node where cycle is detecting, if the oc(which will be found in th visited array) and nc(which will be found in removed pair from queue) 
//doesn't match it means, we are reaching at this node from two different paths, of unequal length ,i.e a graph having cycle with odd nodes is not bipartite,
//and a graph having cycle with even number of nodes is bipartite graph.

class Solution {
    public class Pair{
        int v;
        int color;
        
        Pair(int v, int color){
            this.v = v;
            this.color = color;
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        
        for(int v = 0; v < graph.length; ++v){
            if(visited[v] == 0){
                boolean isBipartite = checkBipartite(v, graph, visited);
                if(isBipartite == false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean checkBipartite(int v, int[][] graph, int[] visited){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(v, 1));
        
        while(q.size() > 0){
            Pair rem = q.remove();
            
            if(visited[rem.v] != 0){ //means already visited graph
                int oc = visited[rem.v];
                int nc = rem.color;
                
                if(oc != nc){
                   return false;
                }else{
                    continue;
                }
            }
            
            visited[rem.v] = rem.color;
            
            for(int val : graph[rem.v]){
                if(visited[val] == 0){
                    q.add(new Pair(val, rem.color * -1));
                }
            }
            
        }
        
        return true;
    }   
}

//DFS
class Solution {
    public class Pair{
        int v;
        int color;
        
        Pair(int v, int color){
            this.v = v;
            this.color = color;
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        
        for(int v = 0; v < graph.length; ++v){
            if(visited[v] == 0){
                boolean isBipartite = checkBipartite(v, graph, visited, 1);
                if(isBipartite == false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean checkBipartite(int v, int[][] graph, int[] visited, int color){
        visited[v] = color;
        for(int n : graph[v]){
            if(visited[n] == 0){
                boolean isBip = checkBipartite(n, graph, visited, color * -1);
                if(isBip == false){
                    return false;
                }
            }else{
                int oc = visited[n];
                int nc = color * -1;
                
                if(oc != nc){
                    return false;
                }
            }
        }
        
        return true;
    }   
}
