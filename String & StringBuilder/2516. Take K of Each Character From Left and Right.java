//Two Pointer approach
//TC : O(N)
class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int ca = 0, cb = 0, cc = 0;
        for(int i = 0; i < n; ++i){
            char ch = s.charAt(i);
            if(ch == 'a') ca++;
            if(ch == 'b') cb++;
            if(ch == 'c') cc++;
        }
        
        if(ca < k || cb < k || cc < k) return -1;
        
        int ans = n;
        int lo = n - 1, hi = n - 1;
        while(lo >= 0){
            char lch = s.charAt(lo); //extracting lo pointer character
            if(lch == 'a') ca--;
            if(lch == 'b') cb--;
            if(lch == 'c') cc--;
            
            while(ca < k || cb < k || cc < k){
                char hch = s.charAt(hi); //extracting hi pointer character
                if(hch == 'a') ca++;
                if(hch == 'b') cb++;
                if(hch == 'c') cc++;
                hi--;
            }
            
            int winLength = hi - lo + 1;
            ans = Math.min(ans, n - winLength);
            lo--;
        }
        
        return ans;
    }
}
