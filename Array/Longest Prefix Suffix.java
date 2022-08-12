//User function Template for Java
//O(n)
//isme hame string ka, longest prefix suffix hi batana hai,
class Solution {
    int lps(String s) {
        int i = 1;
        int len = 0;
        int[] lps = new int[s.length()];
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                lps[i] = len + 1;
                len++;
                i++;
            }else if(len == 0){
                lps[i] = 0;
                len = 0;
                i++;
            }else{
                len = lps[len - 1];
            }
        }
        
        return lps[lps.length - 1];
    }
}
