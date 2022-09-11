//TC : O(n)
class Solution{
    long findMaxSubarraySum(long nums[], int N,int X){
        int l = 0;
        long maxSum = Long.MIN_VALUE, sum = 0;
        for(int r = 0; r < nums.length; ++r){
            sum += nums[r];
            
            while(sum > X){
                sum -= nums[l];
                l++;
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        if(maxSum == Long.MIN_VALUE) return 0;
        return maxSum;
    }
}
