//TC : O(N * N)
//SC : O(N * N)
class Solution{
    public int LongestRepeatingSubsequence(String str){
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        
        for(int i = str.length() - 1; i >= 0; --i){
            for(int j = str.length() - 1; j >= 0; --j){
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(j);
                
                if(ch1 == ch2 && i != j){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return dp[0][0];
    }
}
