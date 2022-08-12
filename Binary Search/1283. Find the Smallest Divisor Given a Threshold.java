//TC : nlog(n)
//if we keep (lo <= hi) loop goes infinite

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;
      
        for(int val : nums){
           if(val > hi){
              hi = val;
           }
        }
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            int sum = 0;
            for(int val : nums){
                int q = (val + mid - 1) / mid; //add (mid - 1) to get ceil of quotient
                sum += q;
            }
            
            if(sum > threshold){
                lo = mid + 1; //kyuki mid per gadbad aaya hi hai to, to lo ko mid + 1 kar do
            }else{
                hi = mid; //matlab aur accha answer nikalo ,mid to possible answer ho hi sakta hai
            }
        }
        
        return lo;
    }
}
