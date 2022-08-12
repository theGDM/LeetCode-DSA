//TC : nlog(SIZE),where size is the search space, size = (Max(piles[i]) - 1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int las = 1; //lowest allowed speed
        int has = 0; //highest allowed speed
        for(int pile : piles){
            has = Math.max(has, pile);
        }
        
        while(las < has){
            int as = (las + has) / 2; //allowed speed
    
            int totalHours = 0;
            for(int pile : piles){
                int time = (pile + as - 1) / as;
                totalHours += time; //total hours taken to eat all the bananas from piles, if allowed spped is as
            }
            
            if(totalHours > h){
                las = as + 1;
            }else{
                has = as;
            }
        }
        
        return las;
    }
}
