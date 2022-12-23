//TC : O(N * 2);
//SC : O(N * 2)
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        //divide the nums into two region, [0, n - 2], [1, n - 1]
        return Math.max(rob(0, nums.length - 2, nums), rob(1, nums.length - 1, nums));
    }
    
    public int rob(int start, int end, int[] nums){
        int n = nums.length;
        int[][] dp = new int[2][n + 1];
        for(int i = 0; i < 2; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(start, end, nums, 0, dp);
    }
    
    public int helper(int idx, int lastIdx, int[] nums, int lastChoice, int[][] dp){
        if(idx == lastIdx + 1){
            return dp[lastChoice][idx] = 0;
        }
        
        if(dp[lastChoice][idx] != -1){
            return dp[lastChoice][idx];
        }
        
        if(lastChoice == 0){//matlab pahle wala index rob nahi hua hai, to current index ke pash choice hai
            int rob = helper(idx + 1, lastIdx, nums, 1, dp) + nums[idx]; //ki wo rob ho jaaaye ya na hoye
            int notRob = helper(idx + 1, lastIdx, nums, 0, dp);
            return dp[lastChoice][idx] = Math.max(rob, notRob);
        }else{
            int notRob = helper(idx + 1, lastIdx, nums, 0, dp);
            return dp[lastChoice][idx] = notRob;
        }
    }
}
