//"a(bcdefghijkl(mno)p)q"
class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                stk.push("(");
            }else if(ch >= 'a' && ch <= 'z'){
                if(stk.size() > 0 && stk.peek() != "("){
                    String str = stk.pop() + ch;
                    stk.push(str);
                }else{
                    stk.push(ch + "");
                }   
            }else{
                StringBuilder part = new StringBuilder("");
                while(stk.size() > 0 && stk.peek() != "("){
                    String str = stk.pop();
                    part.insert(0, str);
                }
                stk.pop(); //pop opening bracket as well
                stk.push(part.reverse().toString());
            }
        }
        
        if(stk.size() > 1){
            StringBuilder res = new StringBuilder("");
            while(stk.size() > 0){
                res.insert(0, stk.pop());
            }
            
            return res.toString();
        }
        
        return stk.peek();
    }
}


//"a(bcdefghijkl(mno)p)q"
class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stk = new Stack<>();
        StringBuilder open = new StringBuilder("("); //important
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                stk.push(open); //same address open bracket will be pushed in that..
            }else if(ch >= 'a' && ch <= 'z'){
                if(stk.size() > 0 && stk.peek() != open){
                    stk.peek().append(ch);
                }else{
                    stk.push(new StringBuilder(ch + ""));
                }   
            }else{
                StringBuilder part = new StringBuilder("");
                while(stk.size() > 0 && stk.peek() != open){
                    StringBuilder str = stk.pop();
                    part.insert(0, str);
                    
                }
                // System.out.println(part);
                stk.pop(); //pop opening bracket as well
                stk.push(part.reverse());
            }
            
            System.out.println(stk);
        }
        
        if(stk.size() > 1){
            StringBuilder res = new StringBuilder("");
            while(stk.size() > 0){
                res.insert(0, stk.pop());
            }
            
            return res.toString();
        }
        
        return stk.peek().toString();
    }
}
