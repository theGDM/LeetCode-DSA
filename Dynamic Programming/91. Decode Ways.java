//TC : O(N * 2)
//SC : O(N)
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return memo(0, s, dp);
    }
    
    public int memo(int idx, String input, int[] dp){
        if(idx == input.length()){
            return dp[idx] = 1;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int ans = 0;
        if(input.charAt(idx) >= '1' && input.charAt(idx) <= '9'){
            ans += memo(idx + 1, input, dp);
        }
        
        if(idx + 1 < input.length() 
                   && ((input.charAt(idx) == '1' && input.charAt(idx + 1) <= '9')
                   || (input.charAt(idx) == '2' && input.charAt(idx + 1) <= '6'))){
            ans += memo(idx + 2, input, dp);             
        }
        
        return dp[idx] = ans;
    }
}
