//TC : O(N)
//SC : O(N)
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for(String word : words){
            StringBuilder sb = new StringBuilder(word);
            String rev = sb.reverse().toString();
            
            if(map.containsKey(rev)){
                count += 4;
                
                if(map.get(rev) == 1) map.remove(rev); //if only one entry delete it, as it makes the pair
                else map.put(rev, map.get(rev) - 1);
                
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        //as all the words that got paired up, is already counted like, {lc, cl}, {gg, gg}, {cc, cc}, {ab, ba}
        //and now we will need to only add the word whose count is one, and key.charAt(0) == key.charAt(1)
        for(String key : map.keySet()){ //Now check for the word which ha
            if(map.get(key) == 1 && (key.charAt(0) == key.charAt(1))){
                count += 2;
                break;
            }
        }
        
        return count;
    }
}
