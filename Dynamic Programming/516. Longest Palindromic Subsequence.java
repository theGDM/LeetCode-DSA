//TC : O(2^n) Exponential
class Solution {
    public int longestPalindromeSubseq(String s) {
        return helper(0, s.length() - 1, s);
    }
    
    public int helper(int i, int j, String s){
        if(i > j){
            return 0;
        }
        
        if(i == j){
            return 1;
        }
        
        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);
        
        if(ch1 == ch2){
            return 2 + helper(i + 1, j - 1, s);
        }
        
        int option1 = helper(i + 1, j, s);
        int option2 = helper(i, j - 1, s);
        
        return 0 + Math.max(option1, option2);
    }
}

//TC : O(n * n) 
//SC : O(n * n) dp + RCS
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for(int i = 0; i < dp.length; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        return memo(0, s.length() - 1, s, dp);
    }
    
    public int memo(int i, int j, String s, int[][] dp){
        if(i > j){
            return 0;
        }
        
        if(i == j){
            return 1;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);
        
        if(ch1 == ch2){
            return dp[i][j] = 2 + memo(i + 1, j - 1, s, dp);
        }
        
        int option1 = memo(i + 1, j, s, dp);
        int option2 = memo(i, j - 1, s, dp);
        
        return dp[i][j] = 0 + Math.max(option1, option2);
    }
}
