//try with brute force(HW)
//This is done using disjoint set union method
//As we know that disjoint set union helps in finding the cycle in the graph
class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        //every vertex is the root of his own set
        for(int v = 0; v < edges.length; ++v){
            parent[v] = v;
            rank[v] = 0;
        }
        
        for(int[] e : edges){
            int xl = find(e[0]);
            int yl = find(e[1]);
            
            if(xl != yl){   
                union(xl, yl);
            }else{
                return e;
            }
        }
        
        return null;
    }
    
    public void union(int xl, int yl){
        if(rank[xl] < rank[yl]){
            parent[xl] = yl;
        }else if(rank[xl] > rank[yl]){
            parent[yl] = xl;
        }else{
            parent[xl] = yl;
            rank[yl]++;
        }
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            int pox = parent[x];
            int sl = find(pox);
            parent[x] = sl;
            return sl;
        }
    }
}
