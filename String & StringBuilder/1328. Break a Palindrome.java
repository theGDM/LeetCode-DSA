//TC : O(n)
//Faster than 100%
class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        //There is no way to replace a single character to make "a",, "b" not a palindrome, so return an empty string.
    
        StringBuilder sb = new StringBuilder(palindrome);
        int idx = -1;
        for(int i = 0; i < sb.length() / 2; ++i){ //"aba" answer will be "aaa", which is also paldidrome, 
            if(sb.charAt(i) != 'a'){              //after changing one char, if loop runs upto n
                idx = i; 
                break;
            }
        }
        
        if(idx != -1) sb.setCharAt(idx, 'a'); //as we have to make the lexicographically string
        else sb.setCharAt(sb.length() - 1, 'b'); //that means whole string has 'a' charchter in it
        return sb.toString();
    }
}
