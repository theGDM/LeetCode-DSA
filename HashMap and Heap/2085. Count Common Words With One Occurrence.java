//make two hashmap, one for words1 and other for words2
//loop over hm1, and count the words which have single count in each of the hashmap
//O(words1.length) + O(words2.length) + 
class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        
        for(String word : words1) hm1.put(word, hm1.getOrDefault(word, 0) + 1); 
        for(String word : words2) hm2.put(word, hm2.getOrDefault(word, 0) + 1);
        
        int count = 0;
        for(String word : hm1.keySet()) if(hm1.get(word) == 1 && hm2.getOrDefault(word, 0) == 1) ++count;
        return count;
    }
}
