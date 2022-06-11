class Solution {
    public int[] runningSum(int[] nums) {
        int pref = nums[0];
        for(int i = 1;i < nums.length; ++i){
            nums[i] = nums[i] + pref;
            pref = nums[i];
        }
        
        return nums;
    }
}
