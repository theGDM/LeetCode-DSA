//TC : O(s2.length)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] reqFreq = new int[26];
        int[] currFreq = new int[26];
        
        for(int i = 0; i < s1.length(); ++i){ //first make the required frequency array wrt to s1 string
            int idx = s1.charAt(i) - 'a';
            reqFreq[idx]++;
        }
        
        int win = s1.length(); //window size will be the lentgh of s1 string
        
        for(int i = 0; i < s2.length(); ++i){
            if(i < win){ //case 1 for the very first window, in which we first make the window
                int idx = s2.charAt(i) - 'a';
                currFreq[idx]++;
            }else{
                int incIdx = s2.charAt(i) - 'a';
                int excIdx = s2.charAt(i - win) - 'a';
                
                currFreq[incIdx]++;
                currFreq[excIdx]--;
            }
            
            if(isEqual(reqFreq, currFreq) == true){ //check curr frequecy array is matched with the required 
                return true;                  //frequency array, with current window
            }
        }
        
        return false;
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
