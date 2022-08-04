//Two Traversals algorithm
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                sb.append((char)(ch + 32));
            }else if(ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }else if(ch >= '0' && ch <= '9'){
                sb.append(ch);
            }
        }
        
        s = sb.toString();
        
        int l = 0;
        int r = s.length() - 1;
        
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
}
