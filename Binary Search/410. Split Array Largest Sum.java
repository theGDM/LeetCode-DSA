//iss type se partition karna hai ki, badi
//limit jitni decrease karte jaoge, utna hi aapka partition badhega
//limit jitni badhaoge, partition utna hi kam hoyega
class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = Integer.MIN_VALUE; //lowest sum allowed (1 size ka partition to ban hi jaaye, isiliye)
        int hi = 0; //highest sum allowed
        for(int num : nums){
            hi += num;
            lo = Math.max(lo, num);
        }
        
        lo = 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            int limit = mid;
            
            int countParts = 1;
            int currPartSum = 0;

            for(int num : nums){
                if(currPartSum + num <= limit){
                    currPartSum += num;
                }else{
                    currPartSum = num; //here we assuming the banda is within limit, for that lo must be equal to max element
                    countParts++;
                }
            }
            
            if(countParts > m){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
}
