//DFS
//Imp point is that if you are using global variable, dont's pass it in the function call, because then 
//the changes will be local changes not the global changes

class Solution {
    int maxArea = 0;
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int r = 0; r < grid.length; ++r){
            for(int c = 0; c < grid[0].length; ++c){
                if(visited[r][c] == false && grid[r][c] == 1){
                    area = 0;
                    traversalDFS(r, c, grid, visited);
                  
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }
        
        return maxArea;
    }
    
    public void traversalDFS(int r, int c, int[][] grid, boolean[][] visited){
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }else if(visited[r][c] == true){
            return;
        }else if(grid[r][c] == 0){
            return;
        } 
        
        //preorder work
        visited[r][c] = true;
        ++area; //increase the area cell by cell of land
        
        //faith calls
        traversalDFS(r, c - 1, grid, visited); //left
        traversalDFS(r + 1, c, grid, visited); //down
        traversalDFS(r, c + 1, grid, visited); //right
        traversalDFS(r - 1, c, grid, visited); //up
    }
}
