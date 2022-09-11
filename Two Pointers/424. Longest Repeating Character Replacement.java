//TC : O(26 * two pointer) = O(26N)
//SC : O(1)
class Solution {
    public int characterReplacement(String s, int k) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < 26; ++i){
            int temp = helper(s, k, (char)(i + 'A'));
            res = Math.max(res, temp);
        }
        
        return res;
    }
    
    public int helper(String s, int k, char ch){
        int maxLen = 0, l = 0;
        int replace = 0;
        
        for(int r = 0; r < s.length(); ++r){
            if(s.charAt(r) != ch) replace++;
            
            if(replace > k){
                while(l < r && replace > k){ //make subarray valid by excluding left elements
                    if(s.charAt(l) != ch){
                        replace--;
                    }
                    l++;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        
        return maxLen;
    }
}   
