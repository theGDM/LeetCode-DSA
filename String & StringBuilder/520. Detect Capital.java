//TC : O(N)
//SC : O(1)
class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0, smallCount = 0;
        int n = word.length();
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            
            if(ch >= 'A' && ch <= 'Z'){
                capitalCount++;
            }else{
                smallCount++;
            }
        }
        
        if(capitalCount == n || smallCount == n){//either all characters are small or capital
            return true;
        }else if(capitalCount == 1 && smallCount == n - 1){//only one character is capital and rest are small
            if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'){ //so it must be the very first character
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}

//TC : O(N)
//SC : O(1)
class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.equals(word.toUpperCase())) return true;
        else if(word.equals(word.toLowerCase())) return true;
        else{
            String newString = word.substring(1, word.length());
            if(newString.equals(newString.toLowerCase())) return true;
            else return false;
        }
    }
}
