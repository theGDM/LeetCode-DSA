//TC : O(N * Sum)
class Solution{
    public int mod = 1000000007;
    public int perfectSum(int arr[],int n, int sum) { 
	int[][] dp = new int[arr.length + 1][sum + 1];
        for(int i = 0; i < dp.length; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        int ans = memo(0, sum, arr, dp);
        return ans;
    }
	
    public int memo(int idx, int target, int[] arr, int[][] dp) {
        if(idx == arr.length){
            if(target == 0) return dp[idx][target] = 1;
            else return dp[idx][target] = 0;
        }
        
        if(dp[idx][target] != -1) return dp[idx][target];
        
        int yes = 0;
        if(target - arr[idx] >= 0){
            yes = memo(idx + 1, target - arr[idx], arr, dp);
        }
        
        int no = memo(idx + 1, target, arr, dp);
        return dp[idx][target] = (yes + no) % mod;
    }
}

//TC : O(N * Sum)
class Solution{
    public int mod = 1000000007;
	public int perfectSum(int arr[],int n, int target) { 
	    int[][] dp = new int[arr.length + 1][target + 1];
        for(int idx = 0; idx <= arr.length; ++idx){
            for(int sum = 0; sum <= target; ++sum){
                if(idx == 0 && sum == 0){
                    dp[idx][sum] = 1;
                    continue;
                }
                
                if(idx == 0){
                    dp[idx][sum] = 0;
                    continue;
                }
                
                int no = dp[idx - 1][sum];
                int yes = 0;
                if(sum - arr[idx - 1] >= 0){
                    yes = dp[idx - 1][sum - arr[idx - 1]];
                }
                
                dp[idx][sum] = (yes + no) % 1000000007;
            } 
        }
  
        return dp[arr.length][target];
	}
}


//TC : O(N * Sum)
//SC : O(sum)
class Solution{
    public int mod = 1000000007;
	public int perfectSum(int arr[],int n, int target) { 
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
}
