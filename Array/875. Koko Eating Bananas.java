//TC : nlog(n)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int las = 1; //lowest allowed speed
        int has = 0; //highest allowed speed
        for(int pile : piles){
            has = Math.max(has, pile);
        }
        
        while(las < has){
            int as = (las + has) / 2; //allowed speed
    
            int totalTime = 0;
            for(int pile : piles){
                int time = (pile + as - 1) / as;
                totalTime += time;
            }
            
            if(totalTime > h){
                las = as + 1;
            }else{
                has = as;
            }
        }
        
        return las;
    }
}
