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
