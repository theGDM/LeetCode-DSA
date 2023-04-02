//TC : O(N)
class Solution {
    public char repeatedCharacter(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(freq[ch - 'a'] > 0){
                return ch;
            }
            freq[ch - 'a']++;
        }
        
        return 'a';
    }
}
