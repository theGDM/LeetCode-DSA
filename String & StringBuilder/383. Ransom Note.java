//TC : O(N), SC : O(1)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for(int i = 0; i < ransomNote.length(); ++i){
            char ch = ransomNote.charAt(i);
            freq[ch - 'a']++;
        }
        
        for(int i = 0; i < magazine.length(); ++i){
            char ch = magazine.charAt(i);
            if(freq[ch - 'a'] > 0){
                freq[ch - 'a']--;
            }
        }
        
        for(int i = 0; i < 26; ++i){
            if(freq[i] >= 1) return false;
        }
        
        return true;
    }
}
