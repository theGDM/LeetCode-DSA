//TC : O(N * N)
//SC : O(N * N)
// The main idea is to maintain a map of differences seen at each index.

// We iteratively build the map for a new index i, by considering all elements to the left one-by-one.
// For each pair of indices (i,j) and difference d = A[i]-A[j] considered, we check if there was an existing chain at the index j with difference d already.

// If yes, we can then extend the existing chain length by 1.
// Else, if not, then we can start a new chain of length 2 with this new difference d and (A[j], A[i]) as its elements.

// At the end, we can then return the maximum chain length that we have seen so far.
class Solution {
    public int longestArithSeqLength(int[] nums) {
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for(int i = 0; i < nums.length; ++i){
            dp[i] = new HashMap<>();
        }
        
        // We at least have a minimum chain length of 2 now,
        // given that (A[j], A[i]) with the difference d, 
        // by default forms a chain of length 2.
        int maxLen = 2;
        for(int i = 1; i < nums.length; ++i){
            for(int j = 0; j < i; ++j){
                int diff = nums[i] - nums[j];
                
                if(dp[j].containsKey(diff)){
                    // At index j, if we had already seen a difference d,
                    // then potentially, we can add A[i] to the same chain
                    // and extend it by length 1.
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
