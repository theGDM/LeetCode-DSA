//TC : O(nums.length * queries.length)
//SC : O(queries.length), Output space
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        int idx = 0;
        for(int maxSum : queries){
            int count = 0, sum = 0;
            for(int i = 0; i < nums.length; ++i){
                if(sum + nums[i] <= maxSum){
                    sum = sum + nums[i];
                    count++;
                }
            }
            
            res[idx++] = count;
        }
        
        return res;
    }
}

//TC : O(nlogn + mlogn), where m is the size of queries
//SC : O(n), prefix sum
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        //making the prefix sum array;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0]; 
        for(int i = 1; i < nums.length; ++i){
            preSum[i] = nums[i] + preSum[i - 1];
        }
        
        int[] res = new int[queries.length];
        int idx = 0;
        for(int i = 0; i < queries.length; ++i){
            int maxSum = queries[i];
            
            int low = 0, high = preSum.length - 1;
            while(low < high){
                int mid = low + (high - low) / 2;
                
                if(preSum[mid] >= maxSum){
                    high = mid;
                }else{
                    low = mid + 1;
                }
            }
             
            if(preSum[low] > maxSum){
                res[idx++] = low;
            }else{
                res[idx++] = low + 1;
            }
        }
        
        return res;
    }
}
