//TC : O(N * N)
//SC : O(N * N)
class Solution {
    public String longestDupSubstring(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 2];
        int idx = s.length(), len = 0;
        
        for(int i = s.length() - 1; i >= 0; --i){
            for(int j = s.length() - 1; j >= 0; --j){
                int ch1 = s.charAt(i);
                int ch2 = s.charAt(j);
                
                if(ch1 == ch2 && i != j){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                
                if(dp[i][j] > len){
                    idx = i;
                    len = dp[i][j];
                }
            }
        }
        
        return s.substring(idx, idx + len);
    }
}
