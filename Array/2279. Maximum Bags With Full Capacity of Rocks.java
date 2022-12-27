//TC : O(n + nlogn + n)
//SC : O(1)
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int count = 0;
        for(int i = 0; i < n; ++i){
            capacity[i] -= rocks[i]; //means this much more stones can be placed in each bag..
        }
        
        Arrays.sort(capacity); //nlogn
        for(int i = 0; i < n; ++i){
            if(capacity[i] == 0){
                count++; //those bags which were already filled completely
            }else if(capacity[i] > 0 && additionalRocks >= capacity[i]){
                additionalRocks -= capacity[i];
                count++;
            }else if(additionalRocks < capacity[i]){
                break;
            }
        }
        
        return count;
    }
}
