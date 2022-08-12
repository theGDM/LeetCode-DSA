//worst case : O(n), when all the elements are equal
//ex : 5 5 5 2 2 2 2 2 2 2 2 2 2 5 5 7
//ex : 2 2 2 2 2 1 2 2 2
//ex : 2 2 1 2 2 2 2 2 2 
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[hi] > nums[mid]){
                hi = mid;
            }else if(nums[hi] < nums[mid]){
                lo = mid + 1;
            }else{
                hi--; //handle duplicacy
            }
        }
        
        return nums[lo];
    }
}
