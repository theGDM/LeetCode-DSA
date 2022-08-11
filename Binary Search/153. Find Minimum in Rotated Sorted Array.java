//jis index per dip milta hai, actual me utne time hi array ko rotate kiya gaya hai


class Solution {
    //O(n) solution
    public int findMin(int[] nums) {
        for(int i = 1; i < nums.length; ++i){
            if(nums[i - 1] > nums[i]){
                return nums[i];
            }
        }
         
        return nums[0];
    }
    
    //left half -> lo to mid
    //right half -> mid + 1 to hi
    //two cases, not three
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[hi] > nums[mid]){
                //growth in right side, search in left
                hi = mid;
            }else{
                //growth in left, search in right
                lo = mid + 1;
            }
        }
    
        return nums[lo];
    }
}
