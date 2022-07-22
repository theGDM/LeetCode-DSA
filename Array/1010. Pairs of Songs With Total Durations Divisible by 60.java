class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] fmap = new int[60];
        
        int res = 0;
        for(int t : time){
            int val = t % 60;
            
            if(val == 0){
                res += fmap[val];
            }else{
                res += fmap[60 - val];
            }
            
            fmap[val]++;
        }
        
        return res;
    }
}
