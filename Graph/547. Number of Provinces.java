//Easy Questions, based on DSU
class Solution {
    int[] parent;
    int[] rank;
    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        rank = new int[isConnected.length];
        for(int i = 0; i < isConnected.length; ++i){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i = 0; i < isConnected.length; ++i){
            for(int j = 0; j < isConnected.length; ++j){
                if(i != j && isConnected[i][j] == 1){
                    unionHelper(i, j);
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < isConnected.length; ++i){
            if(parent[i] == i){
                count++;
            }   
        }
        
        return count;
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void unionHelper(int x, int y){
        int xl = find(x);
        int yl = find(y);
        
        if(xl != yl){
            if(rank[xl] < rank[yl]){
                parent[xl] = yl;
            }else if(rank[yl] < rank[xl]){
                parent[yl] = xl;
            }else{
                parent[xl] = yl;
                rank[yl]++;
            }
        }
    }
}
