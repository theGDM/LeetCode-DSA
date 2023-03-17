//TC : At worst both calls are taking, O(2^max(m, n)), m and n are lengths of str1 and str2 respectively.
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(0, 0, text1, text2);
    }
    
    public int helper(int i, int j, String text1, String text2){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }
        
        if(text1.charAt(i) == text2.charAt(j)){
            return helper(i + 1, j + 1, text1, text2) + 1;
        }else{
            return Math.max(helper(i + 1, j, text1, text2), helper(i, j + 1, text1, text2));
        }
    }
}

//Memoization
//TC : O(m * n)
//SC : O(m * n) - 2d dp + rcs
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 2];
        for(int i = 0; i < dp.length; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        return LCS(0, 0, text1, text2, dp);
    }
    
    public int LCS(int i, int j, String s1, String s2, int[][] dp){
        if(i == s1.length() || j == s2.length()){
            return dp[i][j] = 0; //LCS of empty string with other string is empty string
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
         
        //if characters are same, take the common from both of them
        if(ch1 == ch2) return dp[i][j] = 1 + LCS(i + 1, j + 1, s1, s2, dp);
        
        //if character is uncommon, either not take s1[i] or s2[j]
        int option1 = LCS(i + 1, j, s1, s2, dp);
        int option2 = LCS(i, j + 1, s1, s2, dp);
        
        return dp[i][j] = 0 + Math.max(option1, option2);
    }
}

//Tabulation
//TC : O(m * n)
//SC : O(m * n) - 2d dp
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 2];
        for(int i = text1.length() - 1; i >= 0; --i){
            for(int j = text2.length() - 1; j >= 0; --j){
                int ch1 = text1.charAt(i);
                int ch2 = text2.charAt(j);
                
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
