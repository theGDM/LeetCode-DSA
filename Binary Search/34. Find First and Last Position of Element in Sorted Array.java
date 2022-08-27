class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int start = -1;
        int end = -1;
        
        //it will help in finding out the start index of the target element
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == target){
                start = mid;
                hi = mid - 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        lo = 0;
        hi = nums.length - 1;
        
        //it will help infinding out the end index of the target element
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == target){
                end = mid;
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return new int[]{start, end};
    }
}
