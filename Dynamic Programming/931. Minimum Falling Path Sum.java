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

//TC : O(n * n)
//SC : O(n * n)
//Tabulation
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int r = m - 1; r >= 0; --r){
            for(int c = 0; c < n; ++c){
                if(r == m - 1){
                    dp[r][c] = matrix[r][c];
                    continue;
                }
                
                if(c == 0){
                    dp[r][c] = Math.min(dp[r + 1][c], dp[r + 1][c + 1]) + matrix[r][c];
                }else if(c == n - 1){
                    dp[r][c] = Math.min(dp[r + 1][c - 1], dp[r + 1][c]) + matrix[r][c];
                }else{
                    dp[r][c] = Math.min(dp[r + 1][c - 1], Math.min(dp[r + 1][c], dp[r + 1][c + 1])) + matrix[r][c];
                }
            }
        }
        
        //finding min in the first row of dp
        for(int c = 0; c < n; ++c){
            res = Math.min(res, dp[0][c]);
        }
        
        return res;
    }
}

//Space optimization
//TC : O(n * n)
//SC : O(n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        for(int c = 0; c < n; ++c){
            dp[c] = matrix[m - 1][c];
        }
        
        for(int r = m - 2; r >= 0; --r){
            int[] tdp = new int[n];
            for(int c = 0; c < n; ++c){
                if(c == 0){
                    tdp[c] = Math.min(dp[c], dp[c + 1]) + matrix[r][c];
                }else if(c == n - 1){
                    tdp[c] = Math.min(dp[c - 1], dp[c]) + matrix[r][c];
                }else{
                    tdp[c] = Math.min(dp[c - 1], Math.min(dp[c], dp[c + 1])) + matrix[r][c];
                }
            }
            dp = tdp;
        }
        
        //finding min in the first row of dp
        for(int c = 0; c < n; ++c){
            res = Math.min(res, dp[c]);
        }
        
        return res;
    }
}
