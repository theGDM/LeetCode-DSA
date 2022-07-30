// For each word b in B,
// we use function counter to count occurrence of each letter.
// We take the maximum occurrences of counts, and use it as a filter of A.

//TC : O(words1.length) + O(words2.length)
//SC : O(1)

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] count = new int[26];
        int[] temp;
        for(String b : words2){
            temp = counter(b); //O(1) as b size is max 10
            
            for(int i = 0; i < 26; ++i){ //O(1), looping for 26 times
                count[i] = Math.max(count[i], temp[i]);
            }
        }
        
        List<String> res = new ArrayList<>();
        for(String a : words1){
            temp = counter(a);
            
            int i = 0;
            for(; i < 26; ++i){
                if(temp[i] < count[i]){
                    break;
                }
            }
            
            if(i == 26) res.add(a);
        }
        
        return res;
        
    }
    
    public int[] counter(String str){
        int[] tempCount = new int[26];
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            tempCount[ch - 'a']++;
        }
        
        return tempCount;
    }
}
