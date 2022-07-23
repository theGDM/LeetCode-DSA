//getting subsequences
//TC : O(2^n) + O(2^n) + O(words.length)
class Solution {
    //brute force get subsequence first, then compare
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<String> ss = getSubsequence(0, s);
        
        HashSet<String> set = new HashSet<>();
        for(String str : ss){
            set.add(str);
        }
         
        int count = 0;
        for(String word : words){
            if(set.contains(word) == true){
                count++;
            }
        }
        
        return count;
    }
    
    public ArrayList<String> getSubsequence(int idx, String s){
        if(idx == s.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        ArrayList<String> smallAns = getSubsequence(idx + 1, s);
        ArrayList<String> ans = new ArrayList<>();
        
        for(String str : smallAns){
            ans.add(s.charAt(idx) + str);
        }
        
        for(String str : smallAns){
            ans.add(str);
        }
        
        return ans;
    }
}


//2nd approach
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, ArrayDeque<String>> hm = new HashMap<>();
        
        for(char c = 'a'; c <= 'z'; ++c){
            hm.put(c, new ArrayDeque<>());
        }
        
        for(String word : words){
            hm.get(word.charAt(0)).addLast(word);
        }
        
        int count = 0;
        for(char c : s.toCharArray()){
            ArrayDeque<String> queue = hm.get(c);
            
            int size = queue.size();
            
            while(size-- > 0){
                String word = queue.removeFirst();
                 
                if(word.length() == 1){
                    count++;
                }else{
                    hm.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        
        return count;
    }
}
