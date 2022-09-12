//TC : O((n - a.b)a.b)
//where a = words array length
//where b = each word length
//we will calll the helper function (n - a.b) times
//Copying of hashtable requires O(a) time
//for loop in helper run, substringSize time i.e (a.b)

//SC : O(a + b) // at worst when all the words are unique, then no of keys in the hash table will be a

class Solution {
    private HashMap<String, Integer> wordsMap = new HashMap<>();
    private int wordLen;//length of individual word
    private int wordCount; //No of word in words array 
    private int substrSize;
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        wordCount = words.length;
        wordLen = words[0].length();
        substrSize = wordCount * wordLen;
        List<Integer> res = new ArrayList<>();
        for(String word : words){
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        
        for(int i = 0; i <= n - substrSize; ++i){
            if(helper(i, s)){
                res.add(i);
            }
        }
        
        return res;
    }
    
    public boolean helper(int i, String s){
        HashMap<String, Integer> curr = new HashMap<>(wordsMap);
        int wordMatch = 0;
        for(int j = i; j < i + substrSize; j += wordLen){
            String word = s.substring(j, j + wordLen);
            if(curr.getOrDefault(word, 0) != 0){
                curr.put(word, curr.get(word) - 1);
                wordMatch++;
            }else{
                break;
            }
        }
        
        return wordMatch == wordCount;
    }
}
