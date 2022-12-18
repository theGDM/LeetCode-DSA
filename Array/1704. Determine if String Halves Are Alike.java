//TC : O(N)
//SC : O(1)
class Solution {
    public boolean halvesAreAlike(String s) {
        int cvow1 = 0, cvow2 = 0;
        for(int i = 0; i < s.length() / 2; ++i){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                cvow1++;
            }
        }
        
        for(int i = s.length() / 2; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                cvow2++;
            }
        }
            
        return cvow1 == cvow2;
    }
}

//TC : O(N)
//SC : O(1)
class Solution {
    public boolean halvesAreAlike(String s) {
        int cvow1 = 0, cvow2 = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                if(i < s.length() / 2) cvow1++;
                else cvow2++;
            }
        }
            
        return cvow1 == cvow2;
    }
}
