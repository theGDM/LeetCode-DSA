//TC : O(N * N)
class Solution{
    static String longestPalin(String s){
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
