public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    //TC : O(n)
    //SC : O(k) 
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(k == 0) return 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxLen = 0;
        int l = 0;

        for(int r = 0; r < s.length(); ++r){
            char ch = s.charAt(r);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            if(freq.size() > k){
                while(l < r && freq.size() > k){
                    char chl = s.charAt(l);
                    if(freq.get(chl) == 1){
                        freq.remove(chl);
                    }else{
                        freq.put(chl, freq.get(chl) - 1);
                    }
                    l++;
                }
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
