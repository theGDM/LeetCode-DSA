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

//TC : O(cap * items)
//SC : O(cap * items)
class Solution { 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int capacity, int wt[], int costs[], int n) {
        int[][] dp = new int[capacity + 1][costs.length + 1];
        for(int item = 0; item <= costs.length; ++item){
            for(int cap = 0; cap <= capacity; ++cap){
                if(item == 0 || cap == 0){
                    dp[cap][item] = 0;
                    continue;
                }
                
                int yes = -1;
                if(cap - wt[item - 1] >= 0){
                    yes = dp[cap - wt[item - 1]][item - 1] + costs[item - 1];
                }
                
                int no = dp[cap][item - 1];
                dp[cap][item] = Math.max(yes, no);
            }
        }
        
        return dp[capacity][costs.length]; 
    } 
}

//TC : O(cap * items)
//SC : O(cap)
class Solution { 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int capacity, int wt[], int costs[], int n) {
        int[] dp = new int[capacity + 1];
        for(int item = 1; item <= costs.length; ++item){
            int[] newDp = new int[capacity + 1];
            for(int cap = 1; cap <= capacity; ++cap){
                int yes = -1;
                if(cap - wt[item - 1] >= 0){
                    yes = dp[cap - wt[item - 1]] + costs[item - 1];
                }
                
                int no = dp[cap];
                newDp[cap] = Math.max(yes, no);
            }
            dp = newDp;
        }
        
        return dp[capacity];
    } 
}


//TC : O(cap * items)
//SC : O(2 * cap)
class Solution { 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int capacity, int wt[], int costs[], int n) {
        int[][] dp = new int[2][capacity + 1];
        for(int item = 1; item <= costs.length; ++item){
            for(int cap = 1; cap <= capacity; ++cap){
                int yes = -1;
                if(cap - wt[item - 1] >= 0){
                    yes = dp[0][cap - wt[item - 1]] + costs[item - 1];
                }
                
                int no = dp[0][cap];
                dp[1][cap] = Math.max(yes, no);
            }
            
            for(int i = 0; i <= capacity; ++i){
                dp[0][i] = dp[1][i];
            }
        }
        
        return dp[0][capacity]; 
    
    } 
}
