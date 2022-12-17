//TC : O(N)
//SC : O(N)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
    
        for(String s : tokens){
            if(s.equals("+") == false && s.equals("-") == false && s.equals("*") == false && s.equals("/") == false){
                stk.push(Integer.parseInt(s));
            }else{
                int b = stk.pop();
                int a = stk.pop();
                String operator = s;
                int ans = operation(a, b, s);
                stk.push(ans);
            }
        }
        
        return stk.peek();
    }
    
    public int operation(int a, int b, String op){
        if(op.equals("+")){
            return a + b;
        }else if(op.equals("-")){
            return a - b;
        }else if(op.equals("*")){
            return a * b;
        }if(op.equals("/")){
            return a / b;
        }
        
        return 0;
    }
}
