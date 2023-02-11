//TC : O(N * N)
//SC : O(N)
class Solution{
	public int maxSumIS(int[] nums, int n)  {  
	    int[] dp = new int[nums.length];
	    int maxSum = 0;
	    for(int i = 0; i < nums.length; ++i){
	        dp[i] = nums[i];
	        for(int j = 0; j < i; ++j){
	            if(nums[j] < nums[i]){
	                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
	            }
	        }
	        maxSum = Math.max(maxSum, dp[i]);
	    }
	    return maxSum;
	}  
}
