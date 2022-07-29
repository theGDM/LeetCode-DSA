//words[i].length == pattern.length
//TC : O(words.length * Pattern.length()) ~ O(N * 20) ~ O(N)
//SC : O(Pattern.length()) + O(words[i].length)
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<Character, Character> map;
        HashSet<Character> set;
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < words.length; ++i){
            String word = words[i];
            
            map = new HashMap<>(); //renew map
            set = new HashSet<>(); //renew set
            boolean flag = true;
            
            //very important part, to check the pattern
            for(int j = 0; j < pattern.length(); ++j){
                char ch = pattern.charAt(j);
                if(map.containsKey(ch)){
                    if(map.get(ch) != word.charAt(j)){
                        flag = false;
                        break;
                    }
                }else{
                    if(set.contains(word.charAt(j))){
                        flag = false;
                        break;
                    }
                    
                    map.put(ch, word.charAt(j));//put in hashmap
                    set.add(word.charAt(j));//put in set
                } 
            }
            
            if(flag == true){
                res.add(word);
            }
        }
        
        return res;
    }
}
