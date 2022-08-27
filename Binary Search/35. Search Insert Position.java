//binary search on answer
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length - 1]) return nums.length;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                 return mid;
            }else if(nums[mid] > target){
                hi = mid;
            }else{
                lo = mid + 1;
            } 
        }
        
        return lo;
    }
}
