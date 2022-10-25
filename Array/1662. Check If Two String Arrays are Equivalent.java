//TC : O(M + N), M is length of word1, N is length of word2

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        for(String word : word1){
            s1.append(word);
        }
        
        StringBuilder s2 = new StringBuilder();
        for(String word : word2){
            s2.append(word);
        }
        
        return s1.toString().equals(s2.toString());
    }
}
