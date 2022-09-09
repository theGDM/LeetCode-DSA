class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] reqFreq = new int[26];
        int[] currFreq = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < p.length(); ++i){ //first make the required frequency array wrt to s1 string
            int idx = p.charAt(i) - 'a';
            reqFreq[idx]++;
        }
        
        int win = p.length(); //window size will be the lentgh of s1 string
        
        for(int i = 0; i < s.length(); ++i){
            if(i < win){ //case 1 for the very first window, in which we first make the window
                int idx = s.charAt(i) - 'a';
                currFreq[idx]++;
            }else{
                int incIdx = s.charAt(i) - 'a';
                int excIdx = s.charAt(i - win) - 'a';
                
                currFreq[incIdx]++;
                currFreq[excIdx]--;
            }
            
            if(isEqual(reqFreq, currFreq) == true){ //check curr frequecy array is matched with the required 
                res.add(i - win + 1);               //frequency array, with current window
            }                                       //add the starting index
        }
        
        return res;
    }
    
    public boolean isEqual(int[] a, int[] b){
        for(int i = 0; i < 26; ++i){
            if(a[i] != b[i]){
                return false;
            }
        }
        
        return true;
    }
}
