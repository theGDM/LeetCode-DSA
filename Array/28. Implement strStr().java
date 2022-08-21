//TC : O(m + n)
//SC : O(1)
//Using KMP Algorithm
class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = getLps(needle);
        
        int i = 0;
        int j = 0;
        
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                
                if(j == needle.length()){
                    return i - j;
                }
            }else if(j == 0){
                i++;
            }else{
                j = lps[j - 1]; 
            }
        }
        
        return -1;
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
