//0's means brick was not there
//1's means brick is there
//2 means brick is broken
class Solution {
    int[] parent;
    int[] rank;
    int[] size;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n + 1];
        rank = new int[m * n + 1];
        size = new int[m * n + 1];
        
        for(int i = 0; i < parent.length; ++i){
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
        
        //mark the cell which hits
        for(int[] hit : hits){
            int x = hit[0];
            int y = hit[1];
            
            //there is a possibility that a cell is hit where there was not brick
            if(grid[x][y] == 1){
                grid[x][y] = 2; //mark 2, means they were not there
            }
        }
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 1){
                    handleAddNbrs(i, j, m, n, grid);
                }
            }
        }
        
        //last hit se start karna hai
        int[] res = new int[hits.length];
        for(int i = hits.length - 1; i >= 0; --i){
            int x = hits[i][0];
            int y = hits[i][1];
            
            if(grid[x][y] == 2){
                int setSizeLead0 = size[find(0)]; //initially set 0 me kitni bricks thi
                grid[x][y] = 1; //now iss cell ke aane se kitna size badh jata hai, set lead 0 ka
                handleAddNbrs(x, y, m, n, grid); //hit wali cell aane se kitna increment hua total brick ka count in set 0
                int nSetSizeLead0 = size[find(0)];
                
                if(nSetSizeLead0 > setSizeLead0){
                    res[i] = nSetSizeLead0 - setSizeLead0 - 1;
                }
            }
        }
        
        return res;
    }
    
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public void handleAddNbrs(int i, int j, int m, int n, int[][] grid){
        int bno = i * n + j + 1; //box number of current cell
        for(int[] dir : dirs){
            int ni = i + dir[0]; //new cell ith
            int nj = j + dir[1]; //new cell jth
            
            if(ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1){
                int nbno = ni * n + nj + 1;
                
                unionHelper(bno, nbno);
            }
        }
        
        //if top brick, union with 0
        if(i == 0){
            unionHelper(0, bno);
        }
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            int pox = parent[x];
            int setLead = find(pox);
            parent[x] = setLead;
            return setLead;
        }
    }
    
    public void unionHelper(int x, int y){
        int xl = find(x);
        int yl = find(y);
        
        if(xl == yl){
            return;
        }
        
        if(rank[xl] < rank[yl]){
            parent[xl] = yl;
            size[yl] += size[xl];
        }else if(rank[yl] < rank[xl]){
            parent[yl] = xl;
            size[xl] += size[yl];
        }else{
            parent[yl] = xl;
            rank[xl]++;
            size[xl] += size[yl];
        }
    }
}
