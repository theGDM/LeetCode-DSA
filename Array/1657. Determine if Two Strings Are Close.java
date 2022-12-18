//TC : O(N) + O(26) + 2 * O(NlogN) + O(26) ~ O(NlogN)
//SC : O(2 * 26) ~ O(1)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        //create the frequency array for both the strings
        for(int i = 0; i < word1.length(); ++i){ //O(n)
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            freq1[ch1 - 'a']++;
            freq2[ch2 - 'a']++;
        }
        
        //if any of the charchter is present in either word1 or word2 but absent in word2 or word1
        //then return false
        for(int i = 0; i < 26; ++i){
            if((freq1[i] > 0 && freq2[i] == 0) || (freq1[i] == 0 && freq2[i] > 0)) return false;
        }
        
        Arrays.sort(freq1); //O(nlogn)
        Arrays.sort(freq2); //O(nlogn)
        
        for(int i = 0; i < 26; ++i){
            if(freq1[i] != freq2[i]) return false;
        }
        
        return true;
    }
}
