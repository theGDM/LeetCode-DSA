//TC : O(cap * items)
//SC : O(cap * items)
class Solution { 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int capacity, int weight[], int costs[], int n) {
        int[][] dp = new int[capacity + 1][costs.length + 1];
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[0].length; ++j){
                dp[i][j] = -1;
            }
        }
        
        return memo(0, capacity, weight, costs, dp); 
    } 
    
    public static int memo(int item, int capacity, int[] wt, int[] costs, int[][] dp){
        if(item == costs.length) return 0; //no item, so no profit, return 0
        if(dp[capacity][item] != -1) return dp[capacity][item];
        
        int yes = -1;
        if(capacity - wt[item] >= 0){
            yes = memo(item + 1, capacity - wt[item], wt, costs, dp) + costs[item];
        }
        
        int no = memo(item + 1, capacity, wt, costs, dp);
        return dp[capacity][item] = Math.max(yes, no);
    }
}
