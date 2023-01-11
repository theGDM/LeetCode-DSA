//TC : O(items * capcity * capacity)
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

//2nd approch
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
        if(idx == costs.length) return dp[cap][idx] = 0;
        if(dp[cap][idx] != -1) return dp[cap][idx];
        
        int yes = -1;
        if(cap - wt[idx] >= 0){
            yes = memo(idx, cap - wt[idx], costs, wt, dp) + costs[idx];
        }
        
        int no = memo(idx + 1, cap, costs, wt, dp);
        
        return dp[cap][idx] = Math.max(yes, no);
    }
}

//Tabulation(Based on 1st Approach) cubic actually
//TC : O(items * capcity * capacity)
//SC : O(items * capcity)
class Solution{
    static int knapSack(int N, int capacity, int costs[], int weight[]){
        int[][] dp = new int[costs.length + 1][capacity + 1];
        for(int item = 0; item <= costs.length; ++item){
            for(int cap = 0; cap <= capacity; ++cap){
                if(item == 0 || cap == 0){
                    dp[item][cap] = 0;
                    continue;
                }
                
                int yes = -1;
                for(int freq = 1; cap >= weight[item - 1] * freq; ++freq){
                    yes = Math.max(yes, dp[item - 1][cap - weight[item - 1] * freq] + costs[item - 1] * freq);
                }
                
                int no = dp[item - 1][cap];
                dp[item][cap] = Math.max(yes, no);
            }
        }
        // for(int i = 0; i < dp.length; ++i){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return dp[costs.length][capacity];
    }
}

//Tabulation(Based on 2nd Approach Optimized Calls) Quadratic actually
class Solution{
    static int knapSack(int N, int capacity, int costs[], int weight[]){
        int[][] dp = new int[costs.length + 1][capacity + 1];
        for(int item = 0; item <= costs.length; ++item){
            for(int cap = 0; cap <= capacity; ++cap){
                if(item == 0 || cap == 0){
                    dp[item][cap] = 0;
                    continue;
                }
                
                int no = dp[item - 1][cap];
                int yes = -1;
                if(cap - weight[item - 1] >= 0){
                    yes = dp[item][cap - weight[item - 1]] + costs[item - 1];
                }
                
                dp[item][cap] = Math.max(yes, no);
            }
        }
        // for(int i = 0; i < dp.length; ++i){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return dp[costs.length][capacity];
    }
}

//Space Optimization
//TC : O(items * capcity)
//SC : O(capcity)
class Solution{
    static int knapSack(int N, int capacity, int costs[], int weight[]){
        int[] dp = new int[capacity + 1];
        for(int item = 1; item <= costs.length; ++item){
            for(int cap = 1; cap <= capacity; ++cap){
                
                int no = dp[cap];
                int yes = -1;
                if(cap - weight[item - 1] >= 0){
                    yes = dp[cap - weight[item - 1]] + costs[item - 1];
                }
                
                dp[cap] = Math.max(yes, no);
            }
        }
        return dp[capacity];
    }
}
