//TC : O(n);
//SC : O(n), worst case
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int max = 0;
        
        while(i < s.length()){
            char ch = s.charAt(i);
            
            if(hm.containsKey(ch)){
                j = Math.max(j, hm.get(ch) + 1); //move j pointer, one position ahead of the previously found 
            }                                    //location
              
            hm.put(ch, i); //map it in dictionary
            int winLen = i - j + 1; //calculate the current length of the window
            // System.out.println(i + " " + j + " " + winLen);
            max = Math.max(max, winLen);
            i++;
        }
        
        return max;
    }
}
