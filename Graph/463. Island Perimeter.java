//in this question we need to find out the perimeter of the single land
//we will increment th p :
                        //1) when we get out of the boundry
                        //2) when we reach to the water cell
//TC : O(N + 4*N) where N = n * m
class Solution {
    int p = 0;
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int r = 0; r < grid.length; ++r){
            for(int c = 0; c < grid[0].length; ++c){
                if(visited[r][c] == false && grid[r][c] == 1){
                    getPerimeter(r, c, grid, visited); //since we know there is one component
                    return p;
                }
            }
        }
        
        return p;
    }
    
    public void getPerimeter(int r, int c, int[][] grid, boolean[][] visited){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){ //crossed the boundry
            ++p;
            return;
        }else if(grid[r][c] == 0){ //reached to the water
            ++p;
            return;
        }else if(visited[r][c] == true){
            return;
        }
        
        //pre order me visit
        visited[r][c] = true;
        
        getPerimeter(r - 1, c, grid, visited); //top
        getPerimeter(r, c - 1, grid, visited); //left
        getPerimeter(r + 1, c, grid, visited); //down
        getPerimeter(r, c + 1, grid, visited); //right
    }
}
