//Brute force using HM
//TC : O(N * m), m is the length of the maximum size word, N is size of words array
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        String ans = "";
        for(int i = 0; i < words.length; ++i){
            String word = words[i], curr = "";
            for(int j = 0; j < word.length(); ++j){
                String part = word.substring(0, j + 1);
                if(map.containsKey(part)){
                    curr = part;
                }else{
                    break;
                }
            }
            
            if(curr.length() > ans.length()){
                ans = curr;
            }
        }
        
        return ans;
    }
}
