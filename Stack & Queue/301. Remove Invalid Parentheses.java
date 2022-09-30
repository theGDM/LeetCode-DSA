//TC : O(2n)
class Solution {
    HashSet<String> set;
    public void helper(String input, String output, int open, int close, int unbalanced){
        if(input.length() == 0){
            if(open == 0 && close == 0 && unbalanced == 0){
                set.add(output);
            }
            return;
        }
        
        char ch = input.charAt(0);
        String newInput = input.substring(1);
        
        if(ch == '('){
            if(open > 0){ //deleting the oepening bracket, it means no addtion of '(' in output, so 
                helper(newInput, output, open - 1, close, unbalanced);//unbalaced remain as it was before
            }
            //Opening ch will always be added
            helper(newInput, output + ch, open, close, unbalanced + 1); //adding the opening ch, in o/p
        }else if(ch == ')'){
            if(close > 0){ //deleting the closing bracket, unbalanced remains same
                helper(newInput, output, open, close - 1, unbalanced);
            }
            
            if(unbalanced > 0){ //adding the closing bracket if, unbalanced is greater than 0
                helper(newInput, output + ch, open, close, unbalanced - 1);
            }
        }else{ //when character is encountered
            helper(newInput, output + ch, open, close, unbalanced);
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        int open = 0; //no. of opening unbalanced brackets
        int close = 0; //no. of closing unbalanced brackets
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                if(open > 0) open--;
                else close++;
            }
        }
        
        set = new HashSet<>();
        helper(s, "", open, close, 0);
        
        List<String> res = new ArrayList<>();
        for(String balancedBracket : set){
            res.add(balancedBracket);
        }
        
        return res;
    }
}

//Little faster
//TC : O(2n)
class Solution {
    HashSet<String> set;
    public void helper(int idx, String input, String output, int open, int close, int unbalanced){
        if(idx == input.length()){
            if(open == 0 && close == 0 && unbalanced == 0){
                set.add(output);
            }
            return;
        }
        
        char ch = input.charAt(idx);
        
        if(ch == '('){
            if(open > 0){ //deleting the oepening bracket, it means no addtion of '(' in output, so 
                helper(idx + 1, input, output, open - 1, close, unbalanced);//unbalaced remain as it was before
            }
            //Opening ch will always be added
            helper(idx + 1, input, output + ch, open, close, unbalanced + 1); //adding the opening ch, in o/p
        }else if(ch == ')'){
            if(close > 0){ //deleting the closing bracket, unbalanced remains same
                helper(idx + 1, input, output, open, close - 1, unbalanced);
            }
            
            if(unbalanced > 0){ //adding the closing bracket if, unbalanced is greater than 0
                helper(idx + 1, input, output + ch, open, close, unbalanced - 1);
            }
        }else{ //when character is encountered
            helper(idx + 1, input, output + ch, open, close, unbalanced);
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        int open = 0; //no. of opening unbalanced brackets
        int close = 0; //no. of closing unbalanced brackets
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                if(open > 0) open--;
                else close++;
            }
        }
        
        set = new HashSet<>();
        helper(0, s, "", open, close, 0);
        
        List<String> res = new ArrayList<>();
        for(String balancedBracket : set){
            res.add(balancedBracket);
        }
        
        return res;
    }
}
