//TC : nlog(n)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = 1000000;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            int sum = 0;
            for(int val : nums){
                int q = (val + mid - 1) / mid;
                sum += q;
            }
            
            if(sum > threshold){
                lo = mid + 1; //kyuki mid per gadbad aaya hi hai to, to lo ko mid + 1 kar do
            }else{
                hi = mid;
            }
        }
        //bahar nikalte hi lo aur hi same hi honge!
        return lo; 
    }
}

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
                int q = (val + mid - 1) / mid;
                sum += q;
            }
            
            if(sum > threshold){
                lo = mid + 1; //kyuki mid per gadbad aaya hi hai to, to lo ko mid + 1 kar do
            }else{
                hi = mid;
            }
        }
        //bahar nikalte hi lo aur hi same hi honge!
        return lo; 
    }
}
