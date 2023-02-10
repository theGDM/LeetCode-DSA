//TC : O(2^N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        return helper(0, -1, nums);
    }
    
    public int helper(int curr, int prev, int[] nums){
        if(curr == nums.length) return 0;
        
        int yes = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            yes = helper(curr + 1, curr, nums) + 1;
        }
        int no = helper(curr + 1, prev, nums);
        
        return Math.max(yes, no);
    }
    
}

//TC : O(N * N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1]; 
        for(int i = 0; i < dp.length; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        return memo(0, -1, nums, dp);
    }
    
    public int memo(int curr, int prev, int[] nums, int[][] dp){
        if(curr == nums.length) return 0;
        
        if(prev != -1 && dp[curr][prev] != -1) return dp[curr][prev];
        
        int yes = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            yes = memo(curr + 1, curr, nums, dp) + 1;
        }
        int no = memo(curr + 1, prev, nums, dp);
        
        if(prev != -1){
            return dp[curr][prev] = Math.max(yes, no);
        }
        
        return Math.max(yes, no);
    }
    
}

//TC : O(N * N)
//SC : O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLIS = 0;
        for(int i = 0; i < nums.length; ++i){
            dp[i] = 1; //if prev does not exist, then current index can have LIS of length of 1
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        return maxLIS;
    }
}
