//TC : O(N * N)
//SC : O(N * N)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Long, Long>[] dp = new HashMap[nums.length];
        for(int i = 0; i < nums.length; ++i){
            dp[i] = new HashMap<>();
        }
        
        long count = 0;
        for(int i = 1; i < nums.length; ++i){
            for(int j = i - 1; j >= 0; --j){
                long diff = 1l * nums[i] - nums[j];
                
                long oldValue = dp[i].getOrDefault(diff, 0l);
                long newValue = oldValue + dp[j].getOrDefault(diff, 0l) + 1l;
                
                dp[i].put(diff, newValue);
                count += dp[j].getOrDefault(diff, 0l);
            }
        }
        
        return (int)count;
    }
}
