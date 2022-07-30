//greedy
//there may be possibility that, gas may be left, even while visiting the all station circularly
//O(n)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int csum = 0;
        int osum = 0;
        int si = 0;
        
        for(int i = 0; i < gas.length; ++i){
            osum += (gas[i] - cost[i]);
            csum += (gas[i] - cost[i]);
            
            if(csum < 0){
                csum = 0;
                si = i + 1;
            }
        }
        
        if(osum >= 0){
            return si;
        }else{ //if(original sum of deltas, obtained is negative than, we can not have ant st. point)
            return -1;
        }
    }
}
