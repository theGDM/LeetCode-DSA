//This question is similar to number of enclaves
class Solution {
    //0's land, 1's water
    boolean flag = true;
    public int closedIsland(int[][] grid) {
        //Exclude all the 0's on the corner, by marking them;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int r = 0; r < grid.length; ++r){
            for(int c = 0; c < grid[0].length; ++c){
                if(visited[r][c] == false && grid[r][c] == 0){
                    flag = true;
                    getConnectedLand(r, c, grid, visited);
                    if(flag == true){
                        ++count;
                    }
                }
            }
        }
        
        return count;
    }
    
    public void getConnectedLand(int r, int c, int[][] grid, boolean[][] visited){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            flag = false; //exit from boundrry
            return;
        }else if(grid[r][c] == 1){
            return;
        }else if(visited[r][c] == true){
            return;
        }
        
        visited[r][c] = true;
        
        getConnectedLand(r - 1, c, grid, visited);
        getConnectedLand(r, c - 1, grid, visited);
        getConnectedLand(r + 1, c, grid, visited);
        getConnectedLand(r, c + 1, grid, visited);
    }
}
