//User function Template for Java
//TC : O(n1 * n2 * n3)
//SC : O(n1 * n2 * n3) <- dp + RCS
class Solution { 
    int LCSof3(String text1, String text2, String text3, int n1, int n2, int n3) { 
        int[][][] dp = new int[text1.length() + 1][text2.length() + 1][text3.length() + 1];
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[0].length; ++j){
                for(int k = 0; k < dp[0][0].length; ++k){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return LCS(0, 0, 0, text1, text2, text3, dp);
    }
    
    public int LCS(int i, int j, int k, String s1, String s2, String s3, int[][][] dp){
        if(i == s1.length() || j == s2.length() || k == s3.length()){
            return dp[i][j][k] = 0; //LCS of empty string with other string is empty string
        }
        
        if(dp[i][j][k] != -1) return dp[i][j][k];
        
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
        char ch3 = s3.charAt(k);
         
        //if characters are same, take the common from both of them
        if(ch1 == ch2 && ch2 == ch3){
            return dp[i][j][k] = 1 + LCS(i + 1, j + 1, k + 1, s1, s2, s3, dp);
        }
        
        //if character is uncommon, either not take s1[i] or s2[j]
        int option1 = LCS(i + 1, j, k, s1, s2, s3, dp);
        int option2 = LCS(i, j + 1, k, s1, s2, s3, dp);
        int option3 = LCS(i, j, k + 1, s1, s2, s3, dp);
        
        
        return dp[i][j][k] = 0 + Math.max(option1, Math.max(option2, option3));
    }
} 
