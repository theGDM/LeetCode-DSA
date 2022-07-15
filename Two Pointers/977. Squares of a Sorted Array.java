//Two pointer concept
//O(n) solution

class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        int[] ans = new int[nums.length];
        
        for(int i = nums.length - 1; i >= 0; --i){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                ans[i] = nums[l] * nums[l];
                l++;
            }else{
                ans[i] = nums[r] * nums[r];
                r--;
            }
        }
        
        return ans;
    }
}
