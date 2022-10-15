//With Stack
//TC : O(n)
//SC : O(n), worst case
class Solution {
    public String removeStars(String str) {
        Stack<Character> ans = new Stack<>();
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            if(ch != '*'){
                ans.push(ch);
            }else if(ans.size() > 0){
                ans.pop();
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(ans.size() > 0){
            res.append(ans.pop());
        }
        
        return res.reverse().toString();
    }
}
