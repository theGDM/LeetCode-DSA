//TC : O(N^2)
//SC : O(2 * N)
class Compute {
    public static int maxSumBS(int nums[], int n){
        //maximum sum increasing subsequence from L to R
        int[] left = new int[n];
        for(int i = 0; i < n; ++i){
            left[i] = nums[i];
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    left[i] = Math.max(left[i], left[j] + nums[i]);
                }
            }
        }
        
        //maximum sum increasing subsequence from L to R
        int[] right = new int[n];
        for(int i = n - 1; i >= 0; --i){
            right[i] = nums[i];
            for(int j = n - 1; j > i; --j){
                if(nums[j] < nums[i]){
                    right[i] = Math.max(right[i], right[j] + nums[i]);
                }
            }
        }
        
        //this question is little weired, as there must be atleast one element on left and right side of peak
        //but it does not take care of that
        int max = nums[0];
        for(int i = 0; i < n; ++i){
            // if(left[i] > nums[i] && right[i] > nums[i]){ //atleast one element must be in the left and right subsequence
            //     int curr = left[i] + right[i] - nums[i];
            //     max = Math.max(max, curr);
            // }
            
            int curr = left[i] + right[i] - nums[i];
            max = Math.max(max, curr);
        }
        
        return max;
    }
}
