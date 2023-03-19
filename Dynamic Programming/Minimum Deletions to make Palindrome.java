//TC : O(n * n)
//SC : O(n * n)
class Solution{
    static int minimumNumberOfDeletions(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev = rev.reverse();
        String s2 = rev.toString();
        //remove the characters which are not making the palindrome
        return s.length() - LCS(s, s2); 
    }
    
    public static int LCS(String s1, String s2){
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
