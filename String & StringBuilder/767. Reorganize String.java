//DISCUSSION - 1
// No Sort O(N):
// count letter appearance and store in hash[i]
// find the letter with largest occurence.
// put the letter into even index numbe (0, 2, 4 ...) char array
// put the rest into the array

//DISCUSSION - 2
// We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
// In this way, we can make sure there is always a gap between the same characters

//DISCUSSION - 3
// Consider this example: "aaabbbcdd", we will construct the string in this way:
// a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
// a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
// a b a c a _ b _ b // fill in "c" at position 3
// a b a c a d b d b // fill in "d" at position 5, 7

// basically the intuition is first fill all the even positions by considering highest frequency char and if there are still some even position remaining fill them first.. once even positions are done the fill odd positions..this way no two adj. chars are same.

// Time O(N): fill hash[] + find the letter + write results into char array
// Space O(N + 26): result + hash[]
class Solution {
    public String reorganizeString(String s) {
        //making the freq of array, to store count of each character
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        
        //find the charachter with maximum occurrence of frequency
        int max = 0;
        int letter = 0;
        for(int i = 0; i < 26; ++i){
            if(freq[i] > max){
                max = freq[i];
                letter = i;
            }
        }
        
        if(max > (s.length() + 1) / 2) return "";
        
        //fill the max occurrence character on even places, like 0, 2, 4, 6, 8 etc
        char[] res = new char[s.length()];
        int idx = 0;
        while(freq[letter] > 0){
            res[idx] = (char)(letter + 'a');
            idx += 2;
            freq[letter]--; //dec count of max occurence character one by one, after positioning in res 
        }
        
        
        //fill rest of the elements
        for(int i = 0; i < 26; ++i){
            while(freq[i] > 0){
                if(idx >= s.length()){
                    idx = 1;
                }
                
                res[idx] = (char)(i + 'a');
                idx += 2;
                freq[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}
