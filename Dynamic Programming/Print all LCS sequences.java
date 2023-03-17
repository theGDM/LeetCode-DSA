class Solution{
    TreeSet<String> answers;
    public List<String> all_longest_common_subsequences(String text1, String text2){
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
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
        
        answers = new TreeSet<>();
        helper(0, 0, text1, text2, dp, "");
        List<String> ans = new ArrayList<>();
        for(String str : answers){
            ans.add(str);
        }
        
        return ans;
    }
    
    public void helper(int i, int j, String s1, String s2, int[][] dp,String lcs){
        if(i == s1.length() || j == s2.length()){
            answers.add(lcs);
            return;
        }
        
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
        
        if(ch1 == ch2){
            //character taken (same)
            helper(i + 1, j + 1, s1, s2, dp, lcs + ch1);
        }else{
            //character not taken
            if(dp[i][j] == dp[i + 1][j]){
                helper(i + 1, j, s1, s2, dp, lcs);
            }
            
            if(dp[i][j] == dp[i][j + 1]){
                helper(i, j + 1, s1, s2, dp, lcs);
            }
        }
    }
}
