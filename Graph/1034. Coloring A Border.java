//TC : O(E + V) = O(m * n + 4 * n * m)
//SC : O(n * m)
//DFS Traversal
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] ans = new int[grid.length][grid[0].length];
        
        int rc = grid[row][col];
        makeBoundry(row, col, rc, grid, visited, color, ans);
        
        //now fill the ans matrix with the cell value which were not visited in the grid matrix
        for(int i = 0;i < grid.length; ++i){
            for(int j = 0;j < grid[0].length; ++j){
                if(visited[i][j] == false){
                    ans[i][j] = grid[i][j];
                }
            }
        }
        
        return ans;
    }
    
    public void makeBoundry(int r, int c, int rc, int[][] grid, boolean[][] visited, int color, int[][] ans){
        //base conditions
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }else if(visited[r][c] == true){
            return;
        }else if(grid[r][c] != rc){
            return;
        }
        
        //preorder visit mark
        visited[r][c] = true;
        
        //work in preorder
        if(checkIfBoundry(r, c, rc, grid)){
            ans[r][c] = color;
        }else{
            ans[r][c] = grid[r][c];
        }
        
        makeBoundry(r, c - 1, rc, grid, visited, color, ans); //left
        makeBoundry(r + 1, c, rc, grid, visited, color, ans); //down
        makeBoundry(r, c + 1, rc, grid, visited, color, ans); //right
        makeBoundry(r - 1, c, rc, grid, visited, color, ans); //up
    }
    
    //code to check for boundry
    public boolean checkIfBoundry(int r, int c, int rc, int[][] grid){
        if(r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1){
            return true;
        }else if(grid[r - 1][c] != rc){
            return true;
        }else if(grid[r][c - 1] != rc){
            return true;
        }else if(grid[r + 1][c] != rc){
            return true;
        }else if(grid[r][c + 1] != rc){
            return true;
        }else{
            return false;
        }
    }
}
