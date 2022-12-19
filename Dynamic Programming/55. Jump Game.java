//TLE
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        
        // return helper(0, nums.length - 1, nums);
        boolean[] dp = new boolean[nums.length];
        return helperMemo(0, nums.length - 1, nums, dp);
    }
    
    public boolean helper(int idx, int n, int[] jumps){
        if(idx == n){
            return true;
        }
        
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            if(idx + jump <= n){
                boolean ans = helper(idx + jump, n, jumps);
                if(ans == true){
                    return ans;
                }
            }
        }
        
        return false;
    }
    
    public boolean helperMemo(int idx, int n, int[] jumps, boolean[] dp){
        if(idx == n){
            return dp[idx] = true;
        }
        
        if(dp[idx] != false){
            return dp[idx];
        }
        
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            if(idx + jump <= n){
                boolean ans = helperMemo(idx + jump, n, jumps, dp);
                if(ans == true){
                    return dp[idx] = true;
                }
            }
        }
        
        return dp[idx] = false;
    }
}
