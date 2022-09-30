//TC : O(n);
class Solution {
    public String smallestSubsequence(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        int[] freq = new int[26];
        boolean[] inQ = new boolean[26];
        
        for(int i = 0; i < s.length(); ++i){
            freq[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            freq[ch - 'a']--; //decrement the count of ch by 1
            
            if(inQ[ch - 'a'] == true){
                continue;
            }
            
            while(dq.size() > 0 && dq.getLast() > ch && freq[dq.getLast() - 'a'] > 0){
                inQ[dq.removeLast() - 'a'] = false; //remove from deque also mark false in inQ
            }
            
            dq.addLast(ch);
            inQ[ch - 'a'] = true;
        }
        
        StringBuilder res = new StringBuilder();
        while(dq.size() > 0){
            res.append(dq.removeFirst());
        }
        return res.toString();
    }
}
