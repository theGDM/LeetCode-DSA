//TC : O(n)
//SC : O(1)
//Using Built in Methods
class Solution {
    public String reverseWords(String s) {
        String[] sarr = s.split("\\s+"); //split on the basis one or more spaces between words
        int l = 0, r = sarr.length - 1;
        
        while(l < r){
            String temp = sarr[l];
            sarr[l] = sarr[r];
            sarr[r] = temp;
            
            l++;
            r--;
        }
        
        return String.join(" ", sarr).trim();
    }
}

