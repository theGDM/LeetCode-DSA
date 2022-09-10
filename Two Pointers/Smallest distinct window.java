//O(256 * s.length())
class Solution {
    public int findSubString(String s) {
        HashMap<Character, Integer> reqFreq = new HashMap<>();
        HashMap<Character, Integer> currFreq = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i){
            char key = s.charAt(i);
            if(reqFreq.containsKey(key) == false){
                reqFreq.put(key, 1);
            }
        }
        
        int minLen = Integer.MAX_VALUE, matchCount = 0;
        int win = reqFreq.size(), start = 0;
        
        int l = 0;
        for(int r = 0; r < s.length(); ++r){
            char ch = s.charAt(r);
            int freq = currFreq.getOrDefault(ch, 0) + 1;
            currFreq.put(ch, freq);
            
            if(freq == reqFreq.getOrDefault(ch, 0)){
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
        
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}
