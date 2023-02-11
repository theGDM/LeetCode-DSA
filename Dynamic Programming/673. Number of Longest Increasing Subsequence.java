//TC : O(N*N)
//SC : O(2N)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int[] count = new int[nums.length];
        
        int maxLIS = 0;
        for(int i = 0; i < nums.length; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    if(dp[j] + 1 == dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] += count[j];
                    }else if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            
            if(count[i] == 0) count[i] = 1;        
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < dp.length; ++i){
            if(dp[i] == maxLIS){
                ans += count[i];
            }
        }
      
        return ans;
    }
}


//TC : O(N * N)
//SC : O(2 * N)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; //length of LIS ending at index i
        Arrays.fill(dp, 1);
        
        int[] count = new int[nums.length]; //count of LIS ending at index i
        Arrays.fill(count, 1);
        
        int maxLIS = 0;
        for(int i = 0; i < nums.length; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i] && dp[i] <= dp[j] + 1){
                    if(dp[i] < dp[j] + 1)
                        count[i] = 0;
                    
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    count[i] += count[j];
                }
            }
                   
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        int countLIS = 0;
        for(int i = 0; i < dp.length; ++i){
            if(dp[i] == maxLIS){ 
                countLIS += count[i];
            }
        }

        return countLIS;
    }
}
