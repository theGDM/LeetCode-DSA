//TC : O(2 * n)
//SC : O(n)
class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        
        for(int i = 0; i < t.length(); ++i){
            char ch = t.charAt(i);
            freq[ch - 'a']--;
        }
        
        for(int i = 0; i < 26; ++i){
            if(freq[i] == -1){
                return (char)(i + 'a');
            }
        }
        
        return 'a';
    }
}
