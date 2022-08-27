//log(n) approach
class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = getMinInRoTatedSortedArray(nums);
        int res1 = binarySearch(0, pivot - 1, nums, target);
        
        if(res1 != -1){
            return true;
        }else{
            int res2 = binarySearch(pivot, nums.length - 1, nums, target);
            if(res2 != -1){
                return true;
            }
        }
        
        return false;
    }
    
    //three parts
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
            }else if(nums[mid] > nums[hi]){
                lo = mid + 1;
            }else{
                if(nums[hi] < nums[hi - 1]){ //in case of we have to return the index of min element
                    lo = hi; //TC :  1 1 1 1 1 1 2 1 1 1 1 1 
                    break; 
                }else{
                    hi--;
                }
            }
        }
        
        return lo;
    }
}

//three parts binary search
class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        //three parts
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == target){
                return true;
            }
            
            if(nums[hi] > nums[mid]){
                if(target >= nums[mid] && target <= nums[hi]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }else if(nums[hi] < nums[mid]){
                if(target >= nums[lo] && target <= nums[mid]){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else{
                hi--;
            }
        }
        
        return false;
    }
}
