class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = Integer.MIN_VALUE; //lowest sum allowed
        int hi = 0; //highest sum allowed
        for(int num : nums){
            hi += num;
            lo = Math.max(lo, num);
        }
        
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
