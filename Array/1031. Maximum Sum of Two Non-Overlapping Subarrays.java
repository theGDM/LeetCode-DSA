//sliding window maximum
//TC : O(N)
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max1 = helper(nums, firstLen, secondLen);
        int max2 = helper(nums, secondLen, firstLen);
        
        return Math.max(max1, max2);
    }
    //left -> i per ya i ke pahle khatam hone wali windows ka max left[i] me store kara lo
    //right -> i ya i ke badd ke pahle jo bhi windows hai unka maximum right[i] me store ho jayega
    public int helper(int[] nums, int fl, int sl){
        int[] left = new int[nums.length];
        int sum = 0;
        
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            
            if(i == fl - 1){
                left[i] = sum;
            }else if(i > fl - 1){
                sum -= nums[i - fl];
                left[i] = Math.max(left[i - 1], sum);
            }
        }
        
        
        int[] right = new int[nums.length];
        sum = 0;
        
        for(int i = nums.length - 1; i >= 0; --i){
            sum += nums[i];
            
            if(i == nums.length - sl){
                right[i] = sum;
            }else if(i < nums.length - sl){
                sum -= nums[i + sl];
                right[i] = Math.max(right[i + 1], sum);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int j = fl - 1; j < nums.length - sl; ++j){
            max = Math.max(max, left[j] + right[j + 1]);
        }
        
        return max;
    }
}
