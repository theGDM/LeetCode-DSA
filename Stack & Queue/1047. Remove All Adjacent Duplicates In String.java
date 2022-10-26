//TC : O(N)
//Stack based Solution
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            boolean flag = false;
            while(stk.size() > 0 && stk.peek() == ch){
                flag = true;
                stk.pop();
            }
            
            if(flag == false){
                stk.push(ch);
            }           
        }
        
        StringBuilder res = new StringBuilder();
        while(stk.size() > 0){
            res.append(stk.pop());
        }
        
        return res.reverse().toString();
    }
}

//2nd little optimized
//TC : O(N)
//Stack based Solution
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(stk.size() > 0 && stk.peek() == ch){
                while(stk.size() > 0 && stk.peek() == ch){  
                    stk.pop();
                }
            }else{
                stk.push(ch);
            }           
        }
        
        StringBuilder res = new StringBuilder();
        for(char ch : stk){ //for each in case of stack
            res.append(ch);
        }
        
        return res.toString();
    }
}

//TC : O(N), 10ms solution
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            int size = res.length();
            if(size > 0 && res.charAt(size - 1) == ch){
                res.deleteCharAt(size - 1);
            }else{
                res.append(ch);
            }           
        }
        return res.toString();
    }
}
