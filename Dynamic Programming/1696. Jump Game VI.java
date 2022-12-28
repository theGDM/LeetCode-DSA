//TC : O(N * K), N is length of the nums array
//SC : O(2 * N)
class Solution {
    public static class Pair{
        int min;
        int max; 
        Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Pair[] jumps = new Pair[nums.length];
        for(int i = 0; i < jumps.length - 1; ++i){
            int min = i + 1;
            int max = Math.min(n - 1, i + k);
            jumps[i] = new Pair(min, max);
        }
        
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -11111);
        return memo(0, jumps.length - 1, jumps, nums, dp);
    }
    
    public int memo(int idx, int dest, Pair[] jumps, int[] costs, int[] dp){
        if(idx == dest){
            return dp[idx] = costs[idx];
        }
        
        if(dp[idx] != -11111){
            return dp[idx];
        }
        
        int ans = Integer.MIN_VALUE;
        for(int jump = jumps[idx].min; jump <= jumps[idx].max; ++jump){
            ans = Math.max(ans, memo(jump, dest, jumps, costs, dp));
        }
        
        return dp[idx] = ans + costs[idx];
    }
}

//TC : O(N * K), N is length of the nums array
//SC : O(N)
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return memo(0, n - 1, k, nums, dp);
    }
    
    public int memo(int idx, int dest, int k, int[] costs, int[] dp){
        if(idx == dest){
            return dp[idx] = costs[idx];
        }
        
        if(dp[idx] != Integer.MIN_VALUE){
            return dp[idx];
        }
        
        int ans = Integer.MIN_VALUE;
        for(int jump = 1; jump <= k; ++jump){
            if(idx + jump <= dest){
                ans = Math.max(ans, memo(idx + jump, dest, k, costs, dp));
            }
        }
        
        return dp[idx] = ans + costs[idx];
    }
}
