//TC : O(n)
//SC : O(n)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, minLength = Integer.MAX_VALUE;
        int sum = 0;
        for(int r = 0; r < nums.length; ++r){
            sum += nums[r];
            
            while(sum >= target){
                minLength = Math.min(minLength, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        
        if(minLength == Integer.MAX_VALUE) return 0;
        return minLength;
    }
}
