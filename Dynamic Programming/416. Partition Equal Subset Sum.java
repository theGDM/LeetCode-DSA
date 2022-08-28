class Solution {
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if(sum % 2 == 1) return false; //we can not partition into two sets of equal sum
        int target = sum / 2;
        
        boolean[][] dp = new boolean[nums.length + 1][target + 1]; //DP array
        
        for(int i = 0; i <= nums.length; ++i){
            for(int j = 0; j <= target; ++j){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){ //No team, can't make any run
                    dp[i][j] = false;
                }else if(j == 0){ //0 run banana, any team of any size can make it 
                    dp[i][j] = true;
                }else{
                    if(dp[i - 1][j] == true){ //me batting nahi karta, to baki bachi team j ke barabar
                        dp[i][j] = true;      //run bana sakti hai ki nahi
                    }else{
                        int curr = nums[i - 1]; //we make this much run
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
        return dp[nums.length][target];
    }
    
    public int getSum(int[] nums){
        int sum = 0;
        for(int val : nums){
            sum += val;
        }
        return sum;
    }
}
