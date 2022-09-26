//TC : o(n)
//SC : o(n)
class Solution {
    public int minInsertions(String s) {
        int open = 0, additions = 0;
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                if(open > 0) open--;
                else additions++; //))
                
                if(i + 1 < s.length() && s.charAt(i + 1) == ')'){
                    i++;
                }else{
                    additions++;
                }
            }
        }
        
        return 2 * open + additions;
    }
}
