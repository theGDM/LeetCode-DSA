//TC : O(4 ^(m * n))
//SC : O(m * n)
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int str = 0, stc = 0;
        int empty = 1;
        for(int r = 0; r < m; ++r){
            for(int c = 0; c < n; ++c){
                if(grid[r][c] == 0) empty++;
                else if(grid[r][c] == 1){
                    str = r;
                    stc = c;
                }
            }
        }
        
        return helper(str, stc, m, n, empty, grid, visited);
    }
    
    public int helper(int r, int c, int m, int n, int empty, int[][] grid, boolean[][] visited){
        if(r < 0 || c < 0 || r >= m || c >= n){ //out of boundry
            return 0;
        }else if(grid[r][c] == -1){ //obstatcles
            return 0;
        }else if(visited[r][c] == true){ //already visited cell
            return 0;
        }
        
        if(grid[r][c] == 2){
            if(empty == 0) return 1; //if we covered all the empty cells
            else return 0;
        }
        
        visited[r][c] = true; //mark visited
        empty--;
        int ans = 0;
        ans += helper(r - 1, c, m, n, empty, grid, visited);
        ans += helper(r, c - 1, m, n, empty, grid, visited);
        ans += helper(r + 1, c, m, n, empty, grid, visited);
        ans += helper(r, c + 1, m, n, empty, grid, visited);
        empty++;
        visited[r][c] = false; 
        return ans;
    }
}
