//TC : O(s.length() + t.length())
//SC : O(s.length() + t.length()), worst case, when no backslash charchter
//2ms solution
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    public String build(String str){
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z' && i + 1 < str.length() && str.charAt(i + 1) != '#'){
                ans.append(ch);
            }else if(ch >= 'a' && ch <= 'z' && i + 1 < str.length() && str.charAt(i + 1) == '#'){
                i++;
            }else if(ch == '#'){
                if(ans.length() >= 1) ans.deleteCharAt(ans.length() - 1);
            }else{
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}
