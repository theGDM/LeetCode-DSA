//TC : O(n);
//SC : O(n), worst case
//TC : O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int l = 0, maxLen = 0;
        
        for(int r = 0; r < s.length(); ++r){
            char ch = s.charAt(r);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            
            while(freq.get(ch) > 1){ //tab tak map se remove karte jao, jab tak, ch ka count 1 nahi ho jata
                char chl = s.charAt(l);
                freq.put(chl, freq.get(chl) - 1);
                l++;
            }
            
            maxLen = Math.max(maxLen, r - l + 1);
        }
        
        return maxLen;
    }
}
