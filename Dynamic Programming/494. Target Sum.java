//TC : O(total * N)
//SC : O(N * 2 * total)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = getSum(nums);
        int[][] dp = new int[nums.length + 1][2 * total + 1];
        for(int i = 0; i < dp.length; ++i){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        
        int ans = memo(0, 0, total, target, nums, dp);
        return ans;
    }
	
	public int memo(int idx, int currSum, int total, int target, int[] arr, int[][] dp) {
        if(idx == arr.length){
            if(currSum == target) return dp[idx][currSum + total] = 1;
            else return dp[idx][currSum + total] = 0;
        }
         
        if(dp[idx][currSum + total] != Integer.MIN_VALUE){
            return dp[idx][currSum + total];
        }
        
        int add = memo(idx + 1, currSum + arr[idx], total, target, arr, dp);
        int subtract = memo(idx + 1, currSum - arr[idx], total, target, arr, dp);
        
        return dp[idx][currSum + total] = (add + subtract);
    }
    
    public int getSum(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        return sum;
    }
}

//TC : O(total * N)
//SC : O(target)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = getSum(nums);
        if(total < target) return 0; //even if every element is +ve, we can't make target
        if((total - target) % 2 == 1) return 0;
        int modifiedTarget = (total - target) / 2;
        
        return countTargetSumSubset(nums, modifiedTarget);
    }
	
    //code for target sum subset
	public int countTargetSumSubset(int arr[], int target) { 
	    int[] dp = new int[target + 1];
	    dp[0] = 1;
        for(int idx = 1; idx <= arr.length; ++idx){
            int[] newDp = new int[target + 1];
            for(int sum = 0; sum <= target; ++sum){
                int no = dp[sum];
                int yes = 0;
                if(sum - arr[idx - 1] >= 0){
                    yes = dp[sum - arr[idx - 1]];
                }
                
                newDp[sum] = (yes + no) % 1000000007;
            } 
            
            dp = newDp;
        }
    
        return dp[target];
	}
    
    public int getSum(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        return sum;
    }
}
