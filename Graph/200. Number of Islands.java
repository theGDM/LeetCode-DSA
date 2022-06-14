class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == '1' && visited[r][c] == false){
                    ++count;
                    markLandArea(r, c, grid, visited);
                }
            }
        }
        
        return count;
    }
    
    public void markLandArea(int r, int c, char[][] grid, boolean[][] visited){
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] == true || grid[r][c] == '0'){
            return;
        }
        
        //preorder work
        visited[r][c] = true;
        //faith calls
        markLandArea(r, c - 1, grid, visited); //left
        markLandArea(r + 1, c, grid, visited); //down
        markLandArea(r, c + 1, grid, visited); //right
        markLandArea(r - 1, c, grid, visited); //up
    }
}

//Safe calls
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == '1' && visited[r][c] == false){
                    ++count;
                    markLandArea(r, c, grid, visited);
                }
            }
        }
        
        return count;
    } 
    
    public void markLandArea(int r, int c, char[][] grid, boolean[][] visited){
        //preorder work
        visited[r][c] = true;
        //faith calls
        
        if(r >= 0 && c - 1 >= 0 && r < grid.length && c - 1 < grid[0].length && visited[r][c - 1] == false && grid[r][c - 1] == '1'){
            markLandArea(r, c - 1, grid, visited); //left
        }
        
        if(r + 1 >= 0 && c >= 0 && r + 1 < grid.length && c < grid[0].length && visited[r + 1][c] == false && grid[r + 1][c] == '1'){
            markLandArea(r + 1, c, grid, visited); //down
        }
        
        if(r >= 0 && c + 1 >= 0 && r < grid.length && c + 1 < grid[0].length && visited[r][c + 1] == false && grid[r][c + 1] == '1'){
            markLandArea(r, c + 1, grid, visited); //right
        }
        
        if(r - 1 >= 0 && c >= 0 && r - 1 < grid.length && c < grid[0].length && visited[r - 1][c] == false && grid[r - 1][c] == '1'){
            markLandArea(r - 1, c, grid, visited); //up
        }
           
    }
}
