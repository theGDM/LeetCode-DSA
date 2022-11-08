//TC : O(4^n)
class Solution {
    String[] numToChar;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList();
        numToChar = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        letterCombinations(0, digits, "", res);
        
        return res;
    }
    
    public void letterCombinations(int idx, String digits, String output, List<String> res){
        if(idx == digits.length()){
            res.add(output);
            return;
        }
        
        for(char ch : numToChar[digits.charAt(idx) - '0'].toCharArray()){
            letterCombinations(idx + 1, digits, output + ch, res);
        }
    }
}

class Solution {
    String[] combination;
    public List<String> letterCombinations(String digits) {
        combination = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        
        //edge case, when input is ""
        if(digits.length() == 0) return res;
        
        getComb(0, digits, res, new StringBuilder());
        return res;
    }
    
    public void getComb(int idx, String digits, List<String> res, StringBuilder comb){
        if(idx == digits.length()){
            res.add(comb.toString());
            return;
        }
        
        int num = digits.charAt(idx) - '0';
        String keyChars = combination[num];
        
        for(int i = 0; i < keyChars.length(); ++i){
            comb.append(keyChars.charAt(i));
            getComb(idx + 1, digits, res, comb);
            comb.deleteCharAt(comb.length() - 1); //remove last added char
        }
    }
}
