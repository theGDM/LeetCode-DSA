//TC : O(N + N + N) ~ O(N)
//SC : O(2 * N)
class Solution {
    public int longestMountain(int[] nums) {
        //longest increasing subarray from left to right
        int[] left = new int[nums.length];
        Arrays.fill(left, 1);
        for(int i = 1; i < nums.length; ++i){
            if(nums[i - 1] < nums[i]){
                left[i] = left[i - 1] + 1;
            }
        }
        
        //longest increasing subarray from right to left(longest deccreasing subarray from left to right)
        int[] right = new int[nums.length];
        Arrays.fill(right, 1);
        for(int i = nums.length - 2; i >= 0; --i){
            if(nums[i] > nums[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        
        //making the answer
        int maxLen = 0;
        for(int i = 0; i < nums.length; ++i){
            if(left[i] >= 2 && right[i] >= 2){
                int len = left[i] + right[i] - 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}

//TC : O(N + N + N) ~ O(N)
//SC : O(2 * N)
class Solution {
    public int longestMountain(int[] nums) {
        int n = nums.length;
        //longest increasing subarray from left to right
        int[] left = new int[n];
        for(int i = 0; i < n; ++i){
            if(i > 0 && nums[i - 1] < nums[i]){
                left[i] = left[i - 1] + 1;
            }else{
                left[i] = 1;
            }
        }
        
        //longest increasing subarray from right to left(longest deccreasing subarray from left to right)
        int[] right = new int[n];
        for(int i = n - 1; i >= 0; --i){
            if(i != n - 1 && nums[i] > nums[i + 1]){
                right[i] = right[i + 1] + 1;
            }else{
                right[i] = 1;
            }
        }
        
        //making the answer
        int maxLen = 0;
        for(int i = 0; i < n; ++i){
            if(left[i] >= 2 && right[i] >= 2){
                int len = left[i] + right[i] - 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}
