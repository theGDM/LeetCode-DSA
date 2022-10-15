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
