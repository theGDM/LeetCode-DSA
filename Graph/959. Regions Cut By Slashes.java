//disjoint union set
//dividing each cell into to 4 pieces
class Solution {
    int[] parent;
    int[] rank;
    public int regionsBySlashes(String[] grid) {
        int size = 4 * grid.length * grid[0].length(); //size in 1d
        parent = new int[size];
        rank = new int[size];
        
        for(int i = 0; i < size; ++i){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[i].length(); ++j){
                char ch = grid[i].charAt(j);
                
                int bno = 4 * (i * grid.length + j); //find the box number on the basis of (i, j)
                
                if(ch != '/'){
                    unionHelper(bno + 0, bno + 1);
                    unionHelper(bno + 2, bno + 3);
                }
                
                if(ch != '\\'){
                    unionHelper(bno + 0, bno + 3);
                    unionHelper(bno + 1, bno + 2);
                }
                
                //Two adjacent parts in different cells are contiguous regions.
                //down box ke sath bhi union 
                if(i < grid.length - 1){
                    int obno =  4 * ((i + 1) * grid.length + j);
                    unionHelper(bno + 2, obno + 0);
                }
                
                //right box ke sath bhi union
                if(j < grid[0].length() - 1){
                    int obno = 4 * (i * grid.length + (j + 1));
                    unionHelper(bno + 1, obno + 3);
                }
            }
        }
                                     
        int count = 0;
        for(int i = 0; i < size; ++i){
            if(parent[i] == i){
                count++;
            }
        }
                                     
        return count;
    }
    
    //union helper
    public void unionHelper(int x, int y){
        int xl = find(x);
        int yl = find(y);
        
        if(xl != yl){
            union(xl, yl);
        }
    }
         
    //find
    public int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    //union
    public void union(int xl, int yl){
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
                                     
