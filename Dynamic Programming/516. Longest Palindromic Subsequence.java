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

//TC : O(n * n) 
//SC : O(n * n) dp
class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev = rev.reverse();
        String s2 = rev.toString();
        return LCS(s, s2);
    }
    
    public int LCS(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 2];
        for(int i = s1.length() - 1; i >= 0; --i){
            for(int j = s2.length() - 1; j >= 0; --j){
                int ch1 = s1.charAt(i);
                int ch2 = s2.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return dp[0][0];
    }
}
