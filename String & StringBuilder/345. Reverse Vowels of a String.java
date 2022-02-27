// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

// Example 1:

// Input: s = "hello"
// Output: "holle"
// Example 2:

// Input: s = "leetcode"
// Output: "leotcede"

class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> v = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        //filling all the vowels
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                v.add(ch);
            }
        }
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                ans.append(v.get(v.size() - 1));
                v.remove(v.size() - 1);
            }else{
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}
