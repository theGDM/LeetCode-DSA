//TC : O(2n)
//SC : O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                dq.addLast(i);
            }else if(ch == ')'){
                if(dq.size() > 0 && s.charAt(dq.getLast()) == '(' && ch == ')'){
                    dq.removeLast();
                }else{
                    dq.addLast(i);
                }
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(dq.size() > 0 && dq.getFirst() == i){
                dq.removeFirst(); //remove that from dq, and also that bracket got skipped
            }else{
                res.append(ch);
            }
        }
        
        return res.toString();
    }
}
