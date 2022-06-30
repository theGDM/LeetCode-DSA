class Solution {
    public int uniquePaths(int m, int n) {
        // return helper(0, 0, m - 1, n - 1);
        
        // int[][] dp = new int[m + 1][n + 1];
        // for(int i = 0; i < dp.length; ++i){
        //   Arrays.fill(dp[i], -1);
        // }
        
        // int ans = memoHelper(0, 0, m - 1, n - 1, dp);
        // return ans;
        
        // tabulation
        int[][] dp = new int[m + 1][n + 1];
        for(int sr = m; sr >= 0; --sr){
            for(int sc = n; sc >= 0; --sc){
                if(sr == m - 1 && sc == n - 1){
                    dp[sr][sc] = 1;
                    continue;
                }
 
                int ans = 0;
                if(sc + 1 < n){
                    ans += dp[sr][sc + 1]; //right -> faith call
                }

                if(sr + 1 < m){
                    ans += dp[sr + 1][sc]; //left -> faith call
                }

                dp[sr][sc] = ans;
            }
        }
        
        return dp[0][0];
    }
    
    public int memoHelper(int sr, int sc, int dr, int dc, int[][] dp){
        //+ve base case
        if(sr == dr && sc == dc){
            return dp[sr][sc] = 1;
        }
        
        if(dp[sr][sc] != -1){
            return dp[sr][sc];
        }
        
        int ans = 0;
        if(sc + 1 <= dc){
            ans += memoHelper(sr, sc + 1, dr, dc, dp); //right -> faith call
        }
        
        if(sr + 1 <= dr){
            ans += memoHelper(sr + 1, sc, dr, dc, dp); //left -> faith call
        }
        
        return dp[sr][sc] = ans;
    }
    
    public int helper(int sr, int sc, int dr, int dc){
        //+ve base case
        if(sr == dr && sc == dc){
            return 1;
        }
        
        int ans = 0;
        if(sc + 1 <= dc){
            ans += helper(sr, sc + 1, dr, dc); //right -> faith call
        }
        
        if(sr + 1 <= dr){
            ans += helper(sr + 1, sc, dr, dc); //left -> faith call
        }
        
        return ans;
    }
}
