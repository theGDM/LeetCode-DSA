//Time : O(nlogn + N^2 + n) ~ O(n^2)
//Space : o(2 * n) ~ O(n)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); //sort the nums(Any permutation of valid set is also valid)
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); //fill with 1 initially
        
        int[] prev = new int[nums.length];
        Arrays.fill(prev, -1); //fill with -1 initially
        
        int maxLen = 0, idx = 0;
        for(int i = 1; i < nums.length; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[i] % nums[j] == 0){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            
            if(dp[i] > maxLen){
                maxLen = dp[i];
                idx = i;
            }
        }
        
        //making the answer
        List<Integer> res = new ArrayList<>();
        while(idx != -1){
            res.add(0, nums[idx]);
            idx = prev[idx];
        }
        
        return res;
    }
}
