//Time : O(n^2 + n^2 + n) ~ O(n^2)
//Space : O(2 * n)
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        //longest increasing subsequence from left to right
        int[] left = new int[nums.length];
        for(int i = 0; i < nums.length; ++i){
            left[i] = 1;
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        
        //longest increasing subsequence from right to left
        int[] right = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; --i){
            right[i] = 1;
            for(int j = nums.length - 1; j > i; --j){
                if(nums[j] < nums[i]){
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        
        //Now calculating the longest bitonic subsequence
        //Now it is imporatant to note that, mountain array can not have only decreasing or increasing part
        //it must have both part
        //So for that reason we must have atleast 2 elements, in every subsequece to form valid mountain 
        int maxLen = 0;
        for(int i = 0; i < nums.length; ++i){
            if(left[i] >= 2 && right[i] >= 2){
                int len = left[i] + right[i] - 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        
        //minimum number of elements we should reomve to form the mountain array will be
        int minRemove = nums.length - maxLen;
        return minRemove;
    }
}
