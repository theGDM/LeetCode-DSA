class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == ')'){
                if(stk.peek() == '('){//just top per '(' mil jaaye, means in do brackets ka khud ka koi,
                    return 1;      //independent content nahi hai
                }
                
                int count = 0;
                while(stk.peek() != '('){
                    count++;
                    stk.pop();
                }
                
                if(count == 1) return 1; //if only one character is present between '(' c ')''
                stk.pop();//to make it balanced
            }else{
                stk.push(ch);
            }
        }
        
        return 0;
    }
}
