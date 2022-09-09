//right++ -> travresing towards the valid string
//left++ -> valid string me bhi minimum find karna
//TC : O(n)
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return ""; //edge case
        if(s.equals(t)) return s; 
        
        HashMap<Character, Integer> reqFreq = new HashMap<>();
        HashMap<Character, Integer> currFreq = new HashMap<>();
        
        for(int i = 0; i < t.length(); ++i){
            char key = t.charAt(i);
            reqFreq.put(key, reqFreq.getOrDefault(key, 0) + 1);
        }
        
        int maxLen = Integer.MAX_VALUE;
        int validChar = 0;
        int win = reqFreq.size();
        String ans = ""; 
        
        int j = 0;
        for(int i = 0; i < s.length(); ++i){
            char key = s.charAt(i);
            if(currFreq.getOrDefault(key, 0) + 1 == reqFreq.getOrDefault(key, 0)){
                validChar++;
                
                if(validChar == win){
                    int currLen = i - j + 1;
            
                    if(currLen < maxLen){
                        maxLen = currLen;
                        ans = s.substring(j, i + 1);
                    }
                }
            }
            currFreq.put(key, currFreq.getOrDefault(key, 0) + 1);
            
            //reducing the length of the valid substring if found
            while(j < i && validChar == win){
                char remkey = s.charAt(j);
                if(currFreq.getOrDefault(remkey, 0) - 1 < reqFreq.getOrDefault(remkey, 0)){
                    validChar--;
                }
                
                if(currFreq.get(remkey) == 1){ //remove from left
                    currFreq.remove(remkey);
                }else{
                    currFreq.put(remkey, currFreq.get(remkey) - 1);
                }
                
                j++; //Now update left pointer, after deleting that char from hashmap
                
                if(validChar == win){
                    int currLen = i - j + 1;
                    if(currLen < maxLen){
                        maxLen = currLen;
                        ans = s.substring(j, i + 1);
                    }
                }
            }
        }
        
        return ans;
    }
}

// TC : 1
// "cabwefgewcwaefgcf"
// "cae"

// TC : 2
// "cabwefgewcwaefgcf"
// "cae"
