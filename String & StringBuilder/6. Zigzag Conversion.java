//3 ms solution, faster than 99.41 %
//O(N)
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; ++i){
            if(i == 0 || i == numRows - 1){ //top and bottom rows
                int j = i;
                while(j < s.length()){
                    res.append(s.charAt(j));
                    j += (numRows - 1) * 2;
                }
            }else{ //middle rows
                int j = i;
                while(j < s.length()){
                    res.append(s.charAt(j));
                    int midIdx = j + (numRows - 1) * 2 - 2 * i;
                    if(midIdx < s.length()) res.append(s.charAt(midIdx));
                    j += (numRows - 1) * 2;
                }
            }
        }
        
        return res.toString();
    }
}
