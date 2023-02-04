//TC : O(N * sum)
class Solution{
    public static int mod = 1000000007;
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp = new int[arr.length + 1][sum + 1];
        for(int i = 0; i < dp.length; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        int ans = memo(0, sum, arr, dp);
        return ans > 0 ? true : false;
    }
    
    public static int memo(int idx, int target, int[] arr, int[][] dp) {
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

//TC : O(N * sum)
//SC : O(Sum)
class Solution{
    public static int mod = 1000000007;
    static Boolean isSubsetSum(int N, int arr[], int target){
        boolean[] dp = new boolean[target + 1];
	    dp[0] = true;
        for(int idx = 1; idx <= arr.length; ++idx){
            boolean[] newDp = new boolean[target + 1];
            for(int sum = 0; sum <= target; ++sum){
                boolean no = dp[sum];
                boolean yes = false;
                if(sum - arr[idx - 1] >= 0){
                    yes = dp[sum - arr[idx - 1]];
                }
                
                newDp[sum] = yes || no;
            } 
            
            dp = newDp;
        }
    
        return dp[target];
    }
