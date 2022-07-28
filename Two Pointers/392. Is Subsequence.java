//O(n)
//O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        
        int i = 0; //pointer for subsequence
        int j = 0; //pointer for string
        
        while(j < t.length()){
            if(i == s.length()){
                break; //that means all characters of subsequence is found
            }else if(s.charAt(i) != t.charAt(j)){
                j++; //just increase j pointer by 1
            }else{
                i++;
                j++;
            }
        }
        
        return i == s.length();
    }
}
