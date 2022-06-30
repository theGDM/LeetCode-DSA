//if right ki call nahi lag rahi kisi cell se, that means yadi me right jaunga to infinite cost lagegi
//if down ki call nahi lag rahi kisi cell se, that means yadi me down jaunga to infinite cost lagegi

class Solution {
    public int minPathSum(int[][] grid) {
        // return helperRecursion(0, 0, grid);
        
        // memoization
        // int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        // return helperMemo(0, 0, grid, dp);
        
        // tabulation
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for(int r = grid.length - 1; r >= 0; --r){
            for(int c = grid[0].length - 1; c >= 0; --c){
                if(r == grid.length - 1 && c == grid[0].length - 1){
                    dp[r][c] = grid[r][c];
                    continue;
                }

                int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

                if(c + 1 < grid[0].length){ //call is made to right
                    right = dp[r][c + 1];
                }


                if(r + 1 < grid.length){ //call is made to the left
                    down = dp[r + 1][c];
                }


                int ans = grid[r][c] + Math.min(right, down);
                dp[r][c] = ans;
            }
        }
        
        return dp[0][0];
    }
    
    public int helperMemo(int r, int c, int[][] grid, int[][] dp){
        if(r == grid.length - 1 && c == grid[0].length - 1){
            return dp[r][c] = grid[r][c];
        }
        
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        
        int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        
        if(c + 1 < grid[0].length){ //call is made to right
            right = helperMemo(r, c + 1, grid, dp);
        }
        
        
        if(r + 1 < grid.length){ //call is made to the left
            down = helperMemo(r + 1, c, grid, dp); 
        }
        
        
        int ans = grid[r][c] + Math.min(right, down);
        return dp[r][c] = ans;
    }
    
    public int helperRecursion(int r, int c, int[][] grid){
        if(r == grid.length - 1 && c == grid[0].length - 1){
            return grid[r][c];
        }
        
        int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        
        if(c + 1 < grid[0].length){ //call is made to right
            right = helperRecursion(r, c + 1, grid);
        }
        
        
        if(r + 1 < grid.length){
            down = helperRecursion(r + 1, c, grid); 
        }
        
        
        int ans = grid[r][c] + Math.min(right, down);
        return ans;
    }
}
