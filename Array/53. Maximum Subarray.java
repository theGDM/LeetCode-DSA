// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
// A subarray is a contiguous part of an array.

// Example 1:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

// Example 2:
// Input: nums = [1]
// Output: 1

// Example 3:
// Input: nums = [5,4,-1,7,8]
// Output: 23
 

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104

// //O(n * n) approach
// //generic way : number of subarray : n * n

// class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length - 1; ++i){
            sum = nums[i];
            for(int j = i + 1; j < nums.length; ++j){
                sum += nums[j];
                
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
}

//O(n) Kadane's algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            max = Math.max(max, sum);
            
            if(sum < 0){
                sum = 0;
            }
        }
        
        return max;
    }
}

//if you brought -ve sum before
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i){
            if(sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
}
