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

//TC : O(n)
//SC : O(1)
//Faser than 98% Solution
class Solution {
    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        int n = charArr.length;
        //reverse the whole string
        reverse(0, n - 1, charArr);
        //reverse each word
        reverseWord(charArr, n);
        //clean up the spaces
        return cleanUpSpaces(charArr, n);
    }
    
    public String cleanUpSpaces(char[] arr, int n){
        int i = 0, j = 0;
      
        while (j < n) {
            while(j < n && arr[j] == ' ') j++;            // skip spaces
            while(j < n && arr[j] != ' ') arr[i++] = arr[j++]; // keep non spaces
            while(j < n && arr[j] == ' ') j++;             // skip spaces
            if(j < n) arr[i++] = ' ';                      // keep only one space
        }
        
        return new String(arr).substring(0, i);
    }
    
    public void reverseWord(char[] arr, int n){
        int l = 0, r = 0;
        while(l < n && r < n){
            while(l < n && arr[l] == ' ') l++;
            r = l;
        
            while(r < n && arr[r] != ' ') r++;
        
            reverse(l, r - 1, arr); //reverse the word
            l = r;
        }
    }
    
    public void reverse(int l, int r, char[] arr){
        while(l < r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
