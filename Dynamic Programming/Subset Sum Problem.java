class Solution{
    //TC : O(n2)
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        
        for(int i = 0; i <= arr.length; ++i){
            for(int j = 0; j <= sum; ++j){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){ //No team, can't make any run
                    dp[i][j] = false;
                }else if(j == 0){ //0 run banana 
                    dp[i][j] = true;
                }else{
                    if(dp[i - 1][j] == true){ //me batting nahi karta
                        dp[i][j] = true;
                    }else{
                        int curr = arr[i - 1]; //we make this much run
                        if(j >= curr){
                            if(dp[i - 1][j - curr] == true){
                                dp[i][j] = true;
                            }else{
                                dp[i][j] = false;
                            }
                        }
                    }
                }
            }
        }
        
        return dp[arr.length][sum];
    }
}
