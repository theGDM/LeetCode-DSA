//TC : O(N), Using arrayDeque
class Solution {
    public String makeGood(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(dq.size() > 0 && ch >= 'A' && ch <= 'Z'){
                if(dq.getLast() != ch && Character.toUpperCase(dq.getLast()) == ch){
                    dq.removeLast();
                }else{
                    dq.addLast(ch);
                }
            }else if(dq.size() > 0 && ch >= 'a' && ch <= 'z'){
                if(dq.getLast() != ch && Character.toLowerCase(dq.getLast()) == ch){
                    dq.removeLast();
                }else{
                    dq.addLast(ch);
                }
            }else{
                dq.addLast(ch);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(dq.size() > 0){
            res.append(dq.removeFirst());
        }
        
        return res.toString();
    }
}

//TC : O(N), Using Stack
class Solution {
    public String makeGood(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(stk.size() > 0 && Math.abs(stk.peek() - ch) == 32){
                stk.pop();
            }else{
                stk.push(ch);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(char ch : stk){
            res.append(ch);
        }
        
        return res.toString();
    }
}
