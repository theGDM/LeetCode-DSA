//TC : O(N * 2)
//SC : O(N * 2)
class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length + 1];
        for(int i = 0; i < 2; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(0, nums, 0, dp);
    }
    
    public int helper(int idx, int[] nums, int lastChoice, int[][] dp){
        if(idx == nums.length){
            return dp[lastChoice][idx] = 0;
        }
        
        if(dp[lastChoice][idx] != -1){
            return dp[lastChoice][idx];
        }
        
        if(lastChoice == 0){//matlab pahle wala index rob nahi hua hai, to current index ke pash choice hai
            int rob = helper(idx + 1, nums, 1, dp) + nums[idx]; //ki wo rob ho jaaaye ya na hoye
            int notRob = helper(idx + 1, nums, 0, dp);
            return dp[lastChoice][idx] = Math.max(rob, notRob);
        }else{
            int notRob = helper(idx + 1, nums, 0, dp);
            return dp[lastChoice][idx] = notRob;
        }
    }
}

//TC : O(N)
//SC : O(N)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n + 1];
        
        dp[0][1] = nums[0];
        dp[0][0] = nums[0];
        for(int i = 1; i < n; ++i){
            dp[0][i] = dp[1][i - 1] + nums[i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
        }
            
        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
