//TC : O(2 * s.length)
//SC : O(1) //constant
class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        for(int i = 0; i < t.length(); ++i){
            freq[t.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); ++i){
            if(freq[s.charAt(i) - 'a'] > 0) freq[s.charAt(i) - 'a']--;
        }
        
        int c = 0;
        for(int i = 0; i < freq.length; ++i){
            c += Math.abs(freq[i]);
        }
        
        return c;
    }
}
