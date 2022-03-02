// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".
// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
  
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //finding smallest string
        int min = Integer.MAX_VALUE;
        String smallStr = "";
        for(int i = 0;i < strs.length; ++i){
            if(strs[i].length() < min){
                smallStr = strs[i];
                min = strs[i].length();
            }
        }
        
        String ans = "";
        for(int i = 0; i < smallStr.length(); ++i){
            String sub = smallStr.substring(0, i + 1);
            for(int j = 0;j < strs.length; ++j){
                if(!sub.equals(strs[j].substring(0, i + 1))){
                    return ans;
                }
            }
            ans = sub; // now update the ans, as the current substr
        }
        return ans;
    }
}
