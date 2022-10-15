//TC : O(s.length() + t.length())
//SC : O(s.length() + t.length()), worst case, when no backslash charchter
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    public String build(String str){
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z' && i + 1 < str.length() && str.charAt(i + 1) != '#'){  //"ab"
                ans.append(ch);
            }else if(ch >= 'a' && ch <= 'z' && i + 1 < str.length() && str.charAt(i + 1) == '#'){ //a#
                i++; //not append that char, and also increment by 2
            }else if(ch == '#'){
                if(ans.length() >= 1) ans.deleteCharAt(ans.length() - 1);
            }else{
                ans.append(ch); //last character
            }
        }
        
        return ans.toString();
    }
}

//TC : O(s.length() + t.length())
//SC : O(s.length() + t.length()), worst case, when no backslash charchter
//using stack
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    public String build(String str){
        Stack<Character> ans = new Stack<>();
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            if(ch != '#'){
                ans.push(ch);
            }else if(ans.size() > 0){
                ans.pop();
            }
        }
        
        return String.valueOf(ans);
    }
}
