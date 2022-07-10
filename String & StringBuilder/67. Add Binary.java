class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int c = 0; //initial carry
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0 || c != 0){
            int d1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? b.charAt(j) - '0' : 0;
            
            int rem = (d1 + d2 + c) % 2;
            c = (d1 + d2 + c) / 2;
            
            res.append(rem);
            
            i--;
            j--;
        }
        
        return res.reverse().toString();
    }
}
