//TC : O(N * M)
//SC : O(N * M) DP + RCS
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int i = 0; i < dp.length; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        return memo(0, 0, nums1, nums2, dp);
    }
    
    public int memo(int i, int j, int[] nums1, int[] nums2, int[][] dp){
        if(i == nums1.length || j == nums2.length){
            return dp[i][j] = 0;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int n1 = nums1[i];
        int n2 = nums2[j];
        
        if(n1 == n2){
            return dp[i][j] = 1 + memo(i + 1, j + 1, nums1, nums2, dp);
        }
        
        int option1 = memo(i + 1, j, nums1, nums2, dp);
        int option2 = memo(i, j + 1, nums1, nums2, dp);
        
        return dp[i][j] = 0 + Math.max(option1, option2);
    }
}
