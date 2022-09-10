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

//right++ -> travresing towards the valid string
//left++ -> valid string me bhi minimum find karna
//TC : O(m + n)
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
        
        int minLen = Integer.MAX_VALUE, matchCount = 0;
        int win = reqFreq.size(), start = 0;
        
        int l = 0;
        for(int r = 0; r < s.length(); ++r){
            char ch = s.charAt(r);
            int freq = currFreq.getOrDefault(ch, 0) + 1; 
            currFreq.put(ch, freq);
            
            if(freq == reqFreq.getOrDefault(ch, 0)){ //error arrises, so we use equals, but it is correct , as we doing it in steps
                matchCount++;
            }
            
            while(matchCount == win){
                if(r - l + 1 < minLen){
                    start = l;
                    minLen = r - l + 1;
                }
                
                char chl = s.charAt(l);
                int freql = currFreq.get(chl) - 1;
                currFreq.put(chl, freql);
                
                if(freql + 1 == reqFreq.getOrDefault(chl, 0)){
                    matchCount--;
                }
                
                l++;
            }
        }
        
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}

// TC : 1
// "cabwefgewcwaefgcf"
// "cae"

// TC : 2
// "cabwefgewcwaefgcf"
// "cae"

//right++ -> travresing towards the valid string
//left++ -> valid string me bhi minimum find karna
//TC : O(m + n)
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
        
        int minLen = Integer.MAX_VALUE, matchCount = 0;
        int win = reqFreq.size(), start = 0;
        
        int l = 0;
        for(int r = 0; r < s.length(); ++r){
            char ch = s.charAt(r);
            currFreq.put(ch, currFreq.getOrDefault(ch, 0) + 1);
            
            if(currFreq.getOrDefault(ch, 0).equals(reqFreq.getOrDefault(ch, 0))){
                matchCount++;
            }
            
            while(matchCount == win){
                if(r - l + 1 < minLen){
                    start = l;
                    minLen = r - l + 1;
                }
                
                char chl = s.charAt(l);
                currFreq.put(chl, currFreq.get(chl) - 1);
                
                if(currFreq.getOrDefault(chl, 0) + 1 == reqFreq.getOrDefault(chl, 0)){
                    matchCount--;
                }
                
                l++;
            }
        }
        
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}

// TC : 1
// "cabwefgewcwaefgcf"
// "cae"

// TC : 2
// "cabwefgewcwaefgcf"
// "cae"
