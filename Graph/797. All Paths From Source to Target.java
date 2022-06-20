//1st way, node ke pre and post area me add and remove
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        getAllPath(0, graph.length - 1, graph, visited, path);
        return res;
    }
    
    public void getAllPath(int src, int dest, int[][] graph, boolean[] visited, List<Integer> path){
        if(src == dest){
            path.add(dest); //add the destination too
            res.add(new ArrayList(path));
            path.remove(path.size() - 1); //rremove while we backtrack
            return;
        }
        
        //preorder work
        visited[src] = true;
        path.add(src);
        
        //add nbrs
        for(int v : graph[src]){
            if(visited[v] == false){
                getAllPath(v, dest, graph, visited, path);
            }
        }
        
        //postorder work
        visited[src] = false;
        path.remove(path.size() - 1);
    }
}

//2nd way /edge ke preorder and postorder me add and remove resp.
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        path.add(0);
        getAllPath(0, graph.length - 1, graph, visited, path);
        return res;
    }
    
    public void getAllPath(int src, int dest, int[][] graph, boolean[] visited, List<Integer> path){
        if(src == dest){
            res.add(new ArrayList(path));
            return;
        }
        
        //preorder work
        visited[src] = true;
        
        //add nbrs
        for(int v : graph[src]){
            if(visited[v] == false){
                path.add(v);
                getAllPath(v, dest, graph, visited, path);
                path.remove(path.size() - 1);
            }
        }
        
        //postorder work
        visited[src] = false;
    }
}
