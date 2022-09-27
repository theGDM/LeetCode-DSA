//TC : O(n);
//SC : O(n);
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                stk.push(-1); //( ==> corresponds to -1
            }else if(ch == ')'){
                if(stk.peek() == -1){
                    stk.pop();
                    stk.push(1);
                }else{
                    int val = 0;
                    while(stk.peek() != -1){ //pop till we won't get the -1 i.e opening bracket..
                        val += stk.pop();
                    }
                    stk.pop();
                    stk.push(val * 2);
                }
            }
        }
        
        if(stk.size() > 0){
            int res = 0;
            while(stk.size() > 0){
                res += stk.pop();
            }
            return res;
        }else{
            return stk.peek();
        }
    }
}
