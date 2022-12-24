//TC : O(N * K)
//SC : O(N * K) R.c.s and dp
public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int[][] dp = new int[costs.length + 1][costs[0].length];
        for(int i = 0; i <= costs.length; ++i){
            for(int j = 0; j < costs[0].length; ++j){
                dp[i][j] = -1;
            }
        }

        return memo(0, costs[0].length, -1, costs, dp);
    }

    public int memo(int idx, int k, int prevColor, int[][] costs, int[][] dp){
        if(idx == costs.length){
            return dp[idx][prevColor] = 0;
        }

        if(prevColor != -1 && dp[idx][prevColor] != -1){
            return dp[idx][prevColor];
        }
        
        int min = Integer.MAX_VALUE;
        for(int color = 0; color < k; ++color){
            min = Math.min(min, (prevColor == color) ? Integer.MAX_VALUE : 
                                                       memo(idx + 1, k, color, costs, dp) + costs[idx][color]);
        }

        if(prevColor == -1) return min;
        return dp[idx][prevColor] = min;
    }
}

//TC : O(N * K * k)
//SC : O(N * K) dp
public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int k = costs[0].length;
        int[][] dp = new int[n + 1][k];
        
        for(int c = 0; c < k; ++c){
            dp[0][c] = costs[0][c];
        }

        for(int i = 1; i < n; ++i){
            for(int c = 0; c < k; ++c){
                //getting min in previous row
                int minPrevRow = Integer.MAX_VALUE;
                for(int m = 0; m < k; ++m){
                    if(m == c) continue;
                    minPrevRow = Math.min(minPrevRow, dp[i - 1][m]); 
                }

                dp[i][c] = costs[i][c] + minPrevRow;
            }
        }

        int ans =  Integer.MAX_VALUE;
        for(int c = 0; c < k; ++c){
            ans = Math.min(ans, dp[n - 1][c]);
        }

        return ans;
    }
}

//space optimization
//TC : O(N * (K + k)) ~ O(N * K)
//SC : O(N * K) dp
public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int k = costs[0].length;
        int[][] dp = new int[n + 1][k];
        
        for(int c = 0; c < k; ++c){
            dp[0][c] = costs[0][c];
        }
        
        for(int i = 1; i < n; ++i){
            int firstMin = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for(int prev = 0; prev < k; ++prev){
                if(dp[i - 1][prev] <= firstMin){
                    secondMin = firstMin;
                    firstMin = dp[i - 1][prev];
                }else if(dp[i - 1][prev] <= secondMin){
                    secondMin = dp[i - 1][prev];
                }
            }

            for(int c = 0; c < k; ++c){
                if(dp[i - 1][c] == firstMin) dp[i][c] = costs[i][c] + secondMin;
                else dp[i][c] = costs[i][c] + firstMin;
            }
        }

        int ans =  Integer.MAX_VALUE;
        for(int c = 0; c < k; ++c){
            ans = Math.min(ans, dp[n - 1][c]);
        }

        return ans;
    }
}
