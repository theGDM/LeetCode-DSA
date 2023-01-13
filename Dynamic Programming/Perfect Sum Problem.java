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
