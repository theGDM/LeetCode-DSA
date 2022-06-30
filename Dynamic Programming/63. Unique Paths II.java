class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return recursionHelper(0 ,0 , obstacleGrid);
        if(obstacleGrid[0][0] == 1) return 0; //if we got obstacle on the very first cell, then obviously no path
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0; // //if we got obstacle                                                                       on the very last cell, then obviously no path
         
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        return recursionMemo(0, 0, obstacleGrid, dp);
    }
    
    public int recursionMemo(int r, int c, int[][] grid, int[][] dp){
        if(r == grid.length - 1 && c == grid[0].length - 1){
            return dp[r][c] = 1;
        }
        
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        
        int ans = 0;
        if(c + 1 < grid[0].length && grid[r][c + 1] != 1){
            ans += recursionMemo(r, c + 1, grid, dp);
        }
        
        if(r + 1 < grid.length && grid[r + 1][c] != 1){
            ans += recursionMemo(r + 1, c, grid, dp);
        }
        
        return dp[r][c] = ans;
    }
    
    public int recursionHelper(int r, int c, int[][] grid){
        if(r == grid.length - 1 && c == grid[0].length - 1){
            if(grid[r][c] == 1){
                return 0;
            }else{
                return 1;
            }
        }
        
        int ans = 0;
        if(c + 1 < grid[0].length && grid[r][c + 1] != 1){
            ans += recursionHelper(r, c + 1, grid);
        }
        
        if(r + 1 < grid.length && grid[r + 1][c] != 1){
            ans += recursionHelper(r + 1, c, grid);
        }
        
        return ans;
    }
}
