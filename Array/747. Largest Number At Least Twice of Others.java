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

//1 traversal algorithm
class Solution {
    public int dominantIndex(int[] nums) {
        int fmi = -1;
        int smi = -1;
        
        //finding the max
        for(int i = 0; i < nums.length; ++i){
            if(fmi == -1 || nums[i] >= nums[fmi]){
                smi = fmi;
                fmi = i;
            }else if(smi == -1 || nums[i] >= nums[smi]){
                smi = i;
            }
        }
    
        if(nums[smi] * 2 > nums[fmi]){
            return -1;
        }else{
           return fmi; 
        }
    }
}
