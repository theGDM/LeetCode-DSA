//TC : O(N * N * N) approach
class Solution {
    public String longestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev = rev.reverse();
        String s2 = rev.toString();
        return longestCommonSubstring(s, s2);
    }
    
    public String longestCommonSubstring(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        String res = "";
        for(int i = s1.length() - 1; i >= 0; --i){
            for(int j = s2.length() - 1; j >= 0; --j){
                int ch1 = s1.charAt(i);
                int ch2 = s2.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                
                if(dp[i][j] > res.length()){
                    String curr = s1.substring(i, i + dp[i][j]);
                    if(isPalindrome(curr)){
                        res = curr;
                    }
                }
            }
        }
        
        return res;
    }
    
    public boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            
            i++;
            j--;
        }
        return true;
    }
}

//TC : O(N * N) approach
//SC : O(1)
//Expand around center
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int maxLen = 0;
        String res = "";
        
        //for odd length palindrome
        for(int i = 0; i < s.length(); ++i){
            int left = i - 1, right = i + 1, len = 1;
            
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    len = len + 2;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            
            if(len > res.length()){
                res = s.substring(left + 1, right);
            }
        }
        
        //for even length palindrome
        for(int i = 0; i < s.length(); ++i){
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
                int left = i - 1, right = i + 2, len = 2;
                while(left >= 0 && right < s.length()){
                    if(s.charAt(left) == s.charAt(right)){
                        len = len + 2;
                        left--;
                        right++;
                    }else{
                        break;
                    }
                }
                
                if(len > res.length()){
                    res = s.substring(left + 1, right);
                }
            }
        }
        
        return res;
    }
}
