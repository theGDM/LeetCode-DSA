//TC : O(n)
//SC : O(n)
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                stk.add(i);
            }else if(ch == ')'){
                if(stk.size() == 1){
                    String sub = s.substring(stk.peek() + 1, i);
                    res.append(sub);
                }
                
                stk.pop();
            }
        }
        
        return res.toString();
    }
}


//TC : O(n)
//SC : O(n)
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                stk.add(i);
            }else if(ch == ')'){
                int j = stk.pop();
                if(stk.size() == 0){
                    String sub = s.substring(j + 1, i);
                    res.append(sub);
                }
            }
        }
        
        return res.toString();
    }
}
