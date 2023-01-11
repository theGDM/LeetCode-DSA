//TC : O(items * capcity)
//SC : O(items * capcity)
class Solution{
    static int knapSack(int N, int capacity, int costs[], int weight[]){
        int[][] dp = new int[capacity + 1][costs.length + 1];
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[0].length; ++j){
                dp[i][j] = -1;
            }
        }
        
        return memo(0, capacity, costs, weight, dp);
    }
    
    public static int memo(int idx, int cap, int[] costs, int[] wt, int[][] dp){
        if(idx == costs.length || cap == 0) return dp[cap][idx] = 0;
        if(dp[cap][idx] != -1) return dp[cap][idx];
        int no = memo(idx + 1, cap, costs, wt, dp);
        int yes = -1;
        for(int freq = 1; cap >= wt[idx] * freq; ++freq){
            yes = Math.max(yes, memo(idx + 1, cap - wt[idx] * freq, costs, wt, dp) + costs[idx] * freq);
        }
        
        return dp[cap][idx] = Math.max(yes, no);
    }
}
