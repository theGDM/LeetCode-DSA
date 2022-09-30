//lexicographically smallest subsequence, where each character have atmost frquency
//TC : O(n); //worst case
//SC : O(freq.size())

//"acbac" ek se zyada pop ho rahe isiliye while loop lagaya
class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> inStack = new HashMap<>();
        HashMap<Character, Integer> freq = new HashMap<>();
        
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(i == 0){
                stk.push(ch);
                inStack.put(ch, 1);
                freq.put(ch, freq.getOrDefault(ch, 0) - 1);
                continue;
            }
            
            if(inStack.containsKey(ch) == true){
                freq.put(ch, freq.getOrDefault(ch, 0) - 1);
                continue;
            }
            
        
            if(stk.peek() > ch){
                while(stk.size() > 0 && stk.peek() > ch && freq.get(stk.peek()) >= 1){
                    inStack.remove(stk.peek());
                    stk.pop();
                }
                
                stk.push(ch);
                inStack.put(ch, 1);
                freq.put(ch, freq.getOrDefault(ch, 0) - 1);
            }else{
                stk.push(ch);
                inStack.put(ch, 1);
                freq.put(ch, freq.getOrDefault(ch, 0) - 1);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(stk.size() > 0){
            res.insert(0, stk.pop());
        }
        return res.toString();
    }
}

//lexicographically smallest subsequence, where each character have atmost frquency
//TC : O(n); //worst case
//SC : O(freq.size())

//"acbac" ek se zyada pop ho rahe isiliye while loop lagaya
class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> inStack = new HashMap<>();
        HashMap<Character, Integer> freq = new HashMap<>();
        
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(inStack.containsKey(ch) == true){
                freq.put(ch, freq.getOrDefault(ch, 0) - 1);
                continue;
            }
            
            while(stk.size() > 0 && stk.peek() > ch && freq.get(stk.peek()) >= 1){
                inStack.remove(stk.peek());
                stk.pop();
            }
                
            stk.push(ch); //push in stack
            inStack.put(ch, 1); //store in instack map
            freq.put(ch, freq.getOrDefault(ch, 0) - 1); //remove count by one of that ch
        }
        
        StringBuilder res = new StringBuilder();
        while(stk.size() > 0){
            res.insert(0, stk.pop());
        }
        return res.toString();
    }
}

//Using array in place of map
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
