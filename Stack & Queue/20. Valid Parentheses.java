// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false

class Solution {
    public boolean isValid(String s) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stk.push(i);
            }else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if(stk.isEmpty()){
                    return false;
                }else if(s.charAt(stk.peek()) == '(' && s.charAt(i) == ')'){
                    stk.pop();
                }else if(s.charAt(stk.peek()) == '{' && s.charAt(i) == '}'){
                    stk.pop();
                }else if(s.charAt(stk.peek()) == '[' && s.charAt(i) == ']'){
                    stk.pop();
                }else{
                    return false;
                }
            }
        }
        if(stk.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}
