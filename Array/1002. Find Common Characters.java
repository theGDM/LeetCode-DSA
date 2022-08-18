//TC : O(n * 100) = O(n);
//Sc : O(n * 26)

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int[][] freq = new int[words.length][26];
        
        //count the freq of each character of each word in words array
        for(int i = 0; i < words.length; ++i){
            for(int j = 0; j < words[i].length(); ++j){
                char ch = words[i].charAt(j);
                freq[i][ch - 'a']++;
            }
        }
        
        //loop vertically
        for(int j = 0; j < 26; ++j){
            int min = 400;
            for(int i = 0; i < words.length; ++i){
                min = Math.min(min, freq[i][j]);
            }
            
            while(min > 0){
                res.add((char)(j + 'a') + "");
                min--;
            }
        }
        
        return res;
    }
}
