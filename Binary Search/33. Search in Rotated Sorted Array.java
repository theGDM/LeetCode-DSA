//first find the minimum in a rotated sorted array
//then break into two parts of the sorted array
//lo to pivot - 1 and pivot to nums.length - 1
//TC : log(n) + log(n/2) + log(n/2)
//sc : O(1)
class Solution {
    public int search(int[] nums, int target) {
        int pivot = getMinInRoTatedSortedArray(nums);
        int res1 = binarySearch(0, pivot - 1, nums, target);
        
        if(res1 != -1){
            return res1;
        }else{
            int res2 = binarySearch(pivot, nums.length - 1, nums, target);
            return res2;
        }
        
    }
    
    public int binarySearch(int lo, int hi, int[] nums, int target){
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return -1;
    }
    
    public int getMinInRoTatedSortedArray(int[] nums){
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] < nums[hi]){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        
        return lo;
    }
}
