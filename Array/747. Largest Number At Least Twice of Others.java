//2 traversal algorithm
class Solution {
    public int dominantIndex(int[] nums) {
        int maxIdx = 0;
        int max = nums[0];
        
        //finding the max
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
        }
    
        for(int i = 0; i < nums.length; ++i){
            if(i == maxIdx) continue;
            
            if(2 * nums[i] > max){
                return -1;
            }
        }
        
        return maxIdx;
    }
}
