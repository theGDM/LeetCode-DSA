//DFS problem
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < graph.length; ++i){
            boolean isNbrSafe = dfs(i, graph, visited);
            if(isNbrSafe == true){ //those nbrs are visited and safe get added 
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    public boolean dfs(int v, int[][] graph, int[] visited){
        if(visited[v] == 1){ //visited and unsafe
            return false; //it appears again indication of the cycle
        }else if(visited[v] == 2){ //visited and safe
            return true;
        }else{
            visited[v] = 1; //mark visited
            for(int n : graph[v]){
                boolean isNbrSafe = dfs(n, graph, visited);
                if(isNbrSafe == false){ //if any nbr is found unsafe, so the vertex pointing to it
                    return false;       //will also be unsafe
                }
            }
            
            visited[v] = 2; //No edge from this vertex means safe vertex or, all the nbrs of current
            return true;    //vertex are the same
        }
    }
}
