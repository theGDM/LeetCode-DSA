class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        
        //it will map ch of s to t
        HashMap<Character, Character> hm1 = new HashMap<>();
        //it will map ch of t to s
        HashMap<Character, Character> hm2 = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);
            
            if(hm1.containsKey(ch_s) == false){
                if(hm2.containsKey(ch_t) == true){
                    return false;
                }else{
                    hm1.put(ch_s, ch_t);
                    hm2.put(ch_t, ch_s);
                }
            }else{
                if(hm1.get(ch_s) != ch_t){
                    return false;
                }
            }
        }
        
        return true;
    }
}
