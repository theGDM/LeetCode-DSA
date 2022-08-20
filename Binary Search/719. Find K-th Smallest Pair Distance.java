class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int lo = Integer.MAX_VALUE; //minimum gap;
        for(int i = 0; i < nums.length - 1; ++i){
            lo = Math.min(lo, nums[i + 1] - nums[i]);
        }
        
        int hi = nums[nums.length - 1] - nums[0]; //maximum gap
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = 1;
            //O(n) me kaise find kar sakte the ki kitne pair, aapke mid se barabar ya kam hai
            for(int i = 0; i < nums.length; ++i){ //O(n) 
                while(j < nums.length && nums[j] - nums[i] <= mid){
                    j++;
                }
                
                count += j - i - 1;
            }
            
            if(count < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
}
