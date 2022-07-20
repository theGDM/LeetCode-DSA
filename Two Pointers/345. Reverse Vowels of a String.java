class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0;
        int r = s.length() - 1;
        String check = "aeiouAEIOU";
        
        while(l < r){
            while(l < r && check.indexOf(sb.charAt(l)) == -1){
                l++;
            }
            
            while(l < r && check.indexOf(sb.charAt(r)) == -1){
                r--;
            }
            
            char chl = sb.charAt(l);
            char chr = sb.charAt(r);
            
            sb.setCharAt(l, chr);
            sb.setCharAt(r, chl);
            
            l++;
            r--;
        }
        
        return sb.toString();
    }
}
