//O(n2) solution which will give the tle
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //first approach whenever there comes a circular problem, we extent the array to twice the size;
        int n = nums.length;
        int[] temp = new int[2 * n]; //temp array twice the original nums array
        int[] result = new int[n];
        
        //finding the maximum value
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i){
            max = Math.max(max, nums[i]);
        }
        
        for(int i = 0; i < 2 * n; ++i){
            temp[i] = nums[i % n];
        }
        
        for(int i = 0; i < n; ++i){
            result[i] = -1; //initially put -1, as nge
            if(temp[i] == max){ //as we know that max element can not have the next greater element, so cont.
                continue;
            }
            
            for(int j = i + 1; j < 2 * n; ++j){
                if(temp[j] > temp[i]){
                    result[i] = temp[j];
                    break;
                }
            }
        }
        
        return result;
    }
}
