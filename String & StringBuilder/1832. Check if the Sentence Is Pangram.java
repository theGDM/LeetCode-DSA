//TC : O(n)
//SC : O(1)
//Use array as counter
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        for(int i = 0; i < sentence.length(); ++i){
            char ch = sentence.charAt(i);
            freq[ch - 'a']++;
        }
        
        for(int i = 0; i < freq.length; ++i){
            if(freq[i] == 0) return false;
        }
        
        return true;
    }
}

//TC : O(n)
//SC : O(1)
//Find letters one by one(100%) faster
class Solution {
    public boolean checkIfPangram(String sentence) {
        for(int i = 0; i < 26; ++i){
            char ch = (char)(i + 'a');
            if(sentence.indexOf(ch) == -1) return false;
        }    
        return true;
    }
}
