class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        int c = 0; //initial carry
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0 || c != 0){
            int d1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            
            int rem = (d1 + d2 + c) % 10;
            c = (d1 + d2 + c) / 10;
            
            res.append(rem);
            
            i--;
            j--;
        }
        
        return res.reverse().toString();
    }
}
