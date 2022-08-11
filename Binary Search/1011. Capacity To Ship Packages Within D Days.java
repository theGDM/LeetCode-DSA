// Time O(Nlog(maxSIZE)), Where N is size of weights array,  and maxSIZE = (search space) = (sum[w[i]] - max[w[i]])
// where maxSIZE is the size of the search space (sum of weights - max weight).
// Space O(1)
// lowest itni capacity honi chhiye ke bhi bhari weight bhi aa jaye
// ek ship ki minimum capacity kitni honi chhiye ki jisses saare packages  D days me ship ho jaye
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lac = Integer.MIN_VALUE; //lowest allowed capacity
        int hac = 0; //highest allowed capacity
        for(int weight : weights){
            hac += weight;
            lac = Math.max(lac, weight);
        }
        
        while(lac < hac){
            int mid = (lac + hac) / 2;
            int capacity = mid;
            
            int partsReqd = 1;
            int currDayWt = 0; 

            for(int weight : weights){
                if(currDayWt + weight <= capacity){
                    currDayWt += weight;
                }else{
                    currDayWt = weight; //here we assuming the banda is within limit, for that lo must be equal to max element
                    partsReqd++;
                }
            }
            
            if(partsReqd > days){
                lac = mid + 1;
            }else{
                hac = mid;
            }
        }
        
        return lac;
    }
}
