//In this problem we need to find out the max gold, from any position of the cell. So for that we will apply
//the dfs from every cell when the cell value is not equal to 0.
//And from each cell whatever the gold that we get we will compare it with the maxGold and finally return it.
//SC : O(M * N);
//TC : O(M * n)
class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxGold = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] != 0){
                    int ans = helper(i, j, grid, visited);
                    maxGold = Math.max(maxGold, ans);
                }
            }
        }
        
        return maxGold;
    }
    
    public int helper(int r, int c, int[][] grid, boolean[][] visited){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return Integer.MIN_VALUE;
        }else if(visited[r][c] == true){
            return Integer.MIN_VALUE;
        }else if(grid[r][c] == 0){
            return Integer.MIN_VALUE;
        }
        
        visited[r][c] = true;
        
        int ans = 0;
        ans  = Math.max(ans, helper(r - 1, c, grid, visited));
        ans  = Math.max(ans, helper(r, c - 1, grid, visited));
        ans  = Math.max(ans, helper(r + 1, c, grid, visited));
        ans  = Math.max(ans, helper(r, c + 1, grid, visited));
        
        visited[r][c] = false; //backtrack
        return ans + grid[r][c];
    }
}
