class Solution {
    public int opPerform(int a, char op, int b){
        int out = 0;
        switch(op){
            case '+' : out = a + b; break;
            case '-' : out = a - b; break;
            case '*' : out = a * b; break;
            case '/' : out = a / b; break;
        }
        
        return out;
    }
    
    public int precedence(char op){
        if(op == '*' || op == '/'){
            return 2;
        }else if(op == '+' || op == '-'){
            return 1;
        }else{
            return 0;
        }
    }
    
    public String refine(String s){
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == ' ') continue; //if space than ignore
            if(ch == '+'){
                if(str.length() == 0 || str.charAt(str.length() - 1) == '('){
                    str.append("0+"); // +5, (+6
                }else if(str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-'){
                    continue; //5+(+6) = 5+6 and 5-(+6) = 5-6
                }else{
                    str.append('+');
                }
            }else if(ch == '-'){
                if(str.length() == 0 || str.charAt(str.length() - 1) == '('){
                    str.append("0-"); // -5, (-6
                }else if(str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-'){
                    if(str.charAt(str.length() - 1) == '+'){ 
                        str.setCharAt(str.length() - 1, '-');//5+(-6) = 5-6 
                    }else{
                        str.setCharAt(str.length() - 1, '+');//5-(-6) = 5+6
                    }
                }else{
                    str.append('-');
                }
            }else{
                str.append(ch);
            }
        }
        
        return str.toString();
    }
    
    public int calculate(String s) {
        s = refine(s);
        Stack<Integer> operandStk = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i = 0;i < s.length(); ++i){
           char ch = s.charAt(i);
           if(ch >= '0' && ch <= '9'){
               //push operand in operand stack
               int num = 0;
               while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){//"2147483647 + 23"
                   num = num * 10 + (s.charAt(i) - '0');
                   i++;
               }
               
               operandStk.push(num);
               i--;
           }else if(ch == '('){
               operator.push(ch);
           }else if(ch == ')'){
            //operator -> + or - or * or /
               while(operator.peek() != '('){
                   int b = operandStk.pop();
                   int a = operandStk.pop();
                   char op = operator.pop();
                   int res = opPerform(a, op, b);
                   operandStk.push(res);
               }
               operator.pop();//pop opening bracket as well
           }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
               while(operator.size() > 0 && operator.peek() != '(' 
               && precedence(operator.peek()) >= precedence(ch)){
                   int b = operandStk.pop();
                   int a = operandStk.pop();
                   char op = operator.pop();
                   int res = opPerform(a, op, b);
                   operandStk.push(res);
               }
               operator.push(ch);
           }
       }
       while(operator.size() > 0){
           int b = operandStk.pop();
           int a = operandStk.pop();
           char op = operator.pop();
           int res = opPerform(a, op, b);
           operandStk.push(res);
       }

       return operandStk.peek();
    }
}
