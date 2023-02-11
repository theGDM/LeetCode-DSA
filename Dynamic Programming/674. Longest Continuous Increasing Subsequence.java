//TC : O(N)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int curr = 0, max = 0;
        for(int i = 0; i < nums.length; ++i){
            if(i > 0 && nums[i - 1] < nums[i]){
                curr++;
            }else{
                curr = 1;
            }
            
            max = Math.max(max, curr);
        }
        
        return max;
    }
}
