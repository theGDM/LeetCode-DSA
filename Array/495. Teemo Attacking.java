//Greedy Problem
//TC : O(n) solution
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for(int i = 0; i < timeSeries.length - 1; ++i){
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        
        return total + duration;
    }
}
