//Using KMP algorithm
class Solution {
    //sabse bada prefix jo aapka palidrome hai, uske baad jo bhi hai, unko ulta karke aange laga do
    public String shortestPalindrome(String s) {
        String str = s + '$' + new StringBuilder(s).reverse();
        int[] lps = getLps(str);
        int k = lps[lps.length - 1];
        
        return new StringBuilder(s.substring(k, s.length())).reverse() + s;
    }
    
    public int[] getLps(String str){
        int i = 1;
        int len = 0;
        int[] lps = new int[str.length()];
        
        while(i < str.length()){
            if(str.charAt(i) == str.charAt(len)){
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
        
        return lps;
    }
}
