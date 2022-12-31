//TC : O(n * n)
//SC : O(n * n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int r = 0; r < dp.length; ++r){
            for(int c = 0; c < dp[0].length; ++c){
                dp[r][c] = Integer.MIN_VALUE;
            }
        }
        
        for(int c = 0; c < matrix[0].length; ++c){
            res = Math.min(res, helper(0, c, matrix, dp));
        }
        
        return res;
    }
    
    public void print(int[][] dp){
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[0].length; ++j){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public int helper(int r, int c, int[][] matrix, int[][] dp){
        if(r == matrix.length - 1){
            return dp[r][c] = matrix[r][c];
        }
        
        if(dp[r][c] != Integer.MIN_VALUE){
            return dp[r][c];
        }
        
        int ans = Integer.MAX_VALUE;
        if(r + 1 < matrix.length && c - 1 >= 0){
            ans = Math.min(ans, helper(r + 1, c - 1, matrix, dp));
        }
        
        if(r + 1 < matrix.length){
            ans = Math.min(ans, helper(r + 1, c, matrix, dp));
        }        
        
        if(r + 1 < matrix.length && c + 1 < matrix[0].length){
            ans = Math.min(ans, helper(r + 1, c + 1, matrix, dp));
        }
        
        return dp[r][c] = ans + matrix[r][c];
    }
}
