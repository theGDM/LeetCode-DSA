//TLE
//TC : O(N * Max(jums))
//TC : O(10^4 * 10^5) = O(10^9)
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

//TC : O(N)
//SC : O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for(int i = 0; i < nums.length; ++i){
            if(i > reach) return false; //kyuki maximum reach tak hi pahuch sakte hai
            
            if(nums[i] + i > reach){
                reach = nums[i] + i; //update reach
            }
        }
        
        return true;
    }
} 
