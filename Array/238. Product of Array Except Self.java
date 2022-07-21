//TC : O(1) SC : O(n)
//we are maintaing prefix product, matlab apne se pahle ke element ke products
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        // int[] right = new int[nums.length];
        int[] ans = new int[nums.length];
        
        left[0] = 1;
        for(int i = 1; i < nums.length; ++i){
            left[i] = nums[i - 1] * left[i - 1];
        }
        
        //using right array
        // right[nums.length - 1] = 1;
        // for(int i = nums.length - 2; i >= 0; --i){
        //     right[i] = nums[i + 1] * right[i + 1];
        // }
        
        // for(int i = 0;i < nums.length; ++i){
        //     ans[i] = left[i] * right[i];
        // }
        
        int right = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            ans[i] = right * left[i];
            right *= nums[i];
        }
        
        return ans;
    }
}
