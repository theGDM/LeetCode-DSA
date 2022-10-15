//TC : O(n);
//SC : O(n);
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        StringBuilder str = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; --i){
            if(i != 0) str.append(arr[i] + " ");
            else str.append(arr[i]);
        }
        
        return reverse(str); //O(n)
    }
    
    public String reverse(StringBuilder s){
        int i = 0, j = s.length() - 1;
        while(i < j){
            char ith = s.charAt(i);
            char jth = s.charAt(j);
            s.setCharAt(i, jth);
            s.setCharAt(j, ith);
            i++;
            j--;
        }
        
        return s.toString();
    }    
}

//TC : O(n);
//SC : O(n);
class Solution {
    public String reverseWords(String s) {
        char[] chArr = s.toCharArray();
        int l = 0, r = 0;
        
        while(r <= chArr.length){
            if(r == chArr.length || chArr[r] == ' '){
                swap(chArr, l, r - 1);
                l = r; //moving left to where, right is currently 
                l++; //moving left to 1 space ahead
            }
            r++;
        }
        
        return new String(chArr);
    }
    
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}

//TC : O(n); //94 % faster
//SC : O(n);
class Solution {
    public String reverseWords(String s) {
        char[] chArr = s.toCharArray();
        int l = 0, r = 0;
        
        while(r < chArr.length){
            if(r == chArr.length - 1){
                swap(chArr, l, r);
                l = r; //moving left to where, right is currently 
                l++;
            }else if(chArr[r] == ' '){
                swap(chArr, l, r - 1);
                l = r; //moving left to where, right is currently
                l++;
            }
            r++;
        }
        
        return new String(chArr);
    }
    
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
