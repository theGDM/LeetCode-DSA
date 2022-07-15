//make sure that closing bracket should always be less than or equal to opening bracket.
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        getComb(n, "", 0, 0, res);
        return res;
    }
    
    public void getComb(int n, String str, int open, int close, List<String> res){
        if(str.length() == 2 * n){
            res.add(str);
            return;
        }
        
        if(open + 1 <= n){
            getComb(n, str + "(", open + 1, close, res);
        }
        
        if(close + 1 <= open){
            getComb(n, str + ")", open, close + 1, res);
        }
    }
}
