//TC : O(N * Max(jums))
//TC : O(10^4 * 10^3)
//TC : O(N)
class Solution {
    public int jump(int[] nums) {
        // return helper(0, nums.length - 1, nums);
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return helperMemo(0, nums.length - 1, nums, dp);
    }
    
    public int helper(int idx, int n, int[] jumps){
        if(idx == n){
            return 0;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            if(idx + jump <= n){
                ans = Math.min(ans, helper(idx + jump, n, jumps)); 
            }
        }
        
        if(ans != Integer.MAX_VALUE){
            return ans += 1;
        }
        
        return ans;
    }
    
    public int helperMemo(int idx, int n, int[] jumps, int[] dp){
        if(idx == n){
            return dp[idx] = 0;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            if(idx + jump <= n){
                ans = Math.min(ans, helperMemo(idx + jump, n, jumps, dp)); 
            }
        }
        
        if(ans != Integer.MAX_VALUE){
            return dp[idx] = ans + 1;
        }
        
        return dp[idx] = ans;
    }
}
