//TC : O(N * N)
//SC : O(N * N)
class Solution {
    int lengthOfLongestAP(int[] nums, int n) {
        if(n <= 1) return n;
        
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for(int i = 0; i < nums.length; ++i){
            dp[i] = new HashMap<>();
        }
        
        int maxLen = 2;
        for(int i = 1; i < nums.length; ++i){
            for(int j = i - 1; j >= 0; --j){
                int diff = nums[i] - nums[j];
                
                if(dp[j].containsKey(diff)){
                    int newValue = dp[j].get(diff) + 1;
                    dp[i].put(diff, newValue);
                    maxLen = Math.max(maxLen, newValue);
                }else{
                    dp[i].put(diff, 2);
                }
            }
        }
        
        return maxLen;
    }
}
