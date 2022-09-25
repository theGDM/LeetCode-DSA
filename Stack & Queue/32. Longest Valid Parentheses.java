//TC : O(n)
//SC : O(n)
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int maxLen = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                stk.push(i);
            }else if(ch == ')'){
                if(stk.size() > 0 && s.charAt(stk.peek()) == '('){
                    stk.pop();
                }else{
                    stk.push(i);
                }
            }
            
            int j = stk.size() == 0 ? -1 : stk.peek();
            maxLen = Math.max(maxLen, i - j);
        }
        
        return maxLen;
    }
}

//TC : O(n)
//SC : O(n)
//pichle unbalanced characters se kitna aange tak valid ho
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int maxLen = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                stk.push(i);
            }else if(ch == ')'){
                if(stk.size() > 0 && s.charAt(stk.peek()) == '('){
                    stk.pop();
                }else{
                    stk.push(i);
                }
                
                int j = stk.size() == 0 ? -1 : stk.peek();
                maxLen = Math.max(maxLen, i - j);
            }
        }
        
        return maxLen;
    }
}

//TC : O(2n)
//SC : O'(1)
class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0, maxLen = 0;
        
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                open++;
            }else{
                close++;
            }
            
            if(open == close){
                maxLen = Math.max(maxLen, 2 * close);
            }else if(close > open){
                open = close = 0;
            }
        }
        
        open = close = 0;
        for(int i = s.length() - 1; i > 0; --i){
            if(s.charAt(i) == '('){
                open++;
            }else{
                close++;
            }
            
            if(open == close){
                maxLen = Math.max(maxLen, 2 * open);
            }else if(open > close){
                open = close = 0;
            }
        }
        
        return maxLen;
    }
}
