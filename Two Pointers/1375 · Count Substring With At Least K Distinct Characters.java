public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    //TC : O(2n) 
    public long kDistinctCharacters(String s, int k) {
        long n = s.length();
        long totalSubstring = n * (n + 1) / 2;
        return totalSubstring - atMostKUniqueChar(s, k - 1);
    }

    public long atMostKUniqueChar(String s, int k){
        if(k == 0) return 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        long count = 0;
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

            count += (r - l + 1);
        }

        return count;
    }
}
