//User function Template for Java
//So in an undirected graph, there exist a eulerian path, if and only if all the vertex have
//the even degree. //so there must be no vertex with the odd degree.
class Solution{
    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj){
        int oddNbrCount = 0;
        for(int v = 0; v < V; ++v){
            if(adj.get(v).size() % 2 == 1){
                ++oddNbrCount;
            }
        }
        
        return oddNbrCount == 0;
    }
}
