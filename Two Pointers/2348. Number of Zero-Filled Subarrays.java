//TC : O(N)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int l = 0, r = 0;
        long count = 0;
        while(r < nums.length){
            if(nums[l] != 0){
                l = r;
            }
            
            if(nums[r] == 0){
                count += r - l + 1;
            }else{
                l = r;
            }
            r++;
        }
        
        return count;
    }
}

//TC : O(N)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, subArrays = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                subArrays++;
            }else{
                subArrays = 0;
            }
            
            ans += subArrays;
        }
        
        return ans;
    }
}
