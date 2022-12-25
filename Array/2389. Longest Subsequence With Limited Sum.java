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

