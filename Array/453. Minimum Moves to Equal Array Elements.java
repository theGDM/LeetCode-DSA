//instead of increamenting n - 1 , elements, we can decrement one element
//in one step incrementing n - 1 element other than max = decrementing only one element at a time
//relative order will be maintained
class Solution {
    public int minMoves(int[] nums) {
        int count = 0;
        //TLE Question
        while(true){
            int equal = 0;
            for(int i = 0; i < nums.length - 1; ++i){
                if(nums[i] == nums[i + 1]){
                    equal++;
                }
            }
            
            if(equal == nums.length - 1){
                return count;
            }
            
            int max = Integer.MIN_VALUE;
            int idx = -1;
            for(int i = 0; i < nums.length; ++i){
                if(nums[i] > max){
                    idx = i;
                    max = nums[i];
                }
            }  
            
            count++;
            for(int i = 0; i < nums.length; ++i){
                if(i == idx) continue;
                nums[i] = nums[i] + 1;
            }  
        }
    }
}

class Solution {
    public int minMoves(int[] nums) {
        if(nums.length == 0) return 0;
        
        int min = nums[0];
        for(int val : nums){
            min = Math.min(min, val);
        }
        
        int res = 0;
        for(int val : nums){
            res += val - min;
        }
        
        return res;
    }
}
