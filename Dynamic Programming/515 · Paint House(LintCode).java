//TC : O(N * 3)
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int[][] dp = new int[costs.length + 1][3];
        for(int i = 0; i <= costs.length; ++i){
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
        }

        return memo(0, -1, costs, dp);
    }

    public int memo(int idx, int prevColor, int[][] costs, int[][] dp){
        if(idx == costs.length){
            return dp[idx][prevColor] = 0;
        }

        if(prevColor != -1 && dp[idx][prevColor] != -1){
            return dp[idx][prevColor];
        }

        int ansR = (prevColor == 0) ? Integer.MAX_VALUE : memo(idx + 1, 0, costs, dp) + costs[idx][0];
        int ansB = (prevColor == 1) ? Integer.MAX_VALUE : memo(idx + 1, 1, costs, dp) + costs[idx][1];
        int ansG = (prevColor == 2) ? Integer.MAX_VALUE : memo(idx + 1, 2, costs, dp) + costs[idx][2];
        if(prevColor == -1) return Math.min(ansR, Math.min(ansB, ansG));
        return dp[idx][prevColor] = Math.min(ansR, Math.min(ansB, ansG));
    }
}

//TC : O(N * 3)
//SC : O(N * 3)
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        
        int[][] dp = new int[n + 1][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i = 1; i < n; ++i){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        int ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        return ans;
    }
}
