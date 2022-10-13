//TC : O(n)
//SC : O(n)
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 1) return 0;
        
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        
        pref[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            pref[i] = nums[i] + pref[i - 1];
        }
        
        suff[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; --i){
            suff[i] = nums[i] + suff[i + 1];
        }
        
        for(int i = 0; i < nums.length; ++i){
            if(i == 0){
                if(suff[i + 1] == 0){
                    return i;
                }
            }else if(i == nums.length - 1){
                if(pref[i - 1] == 0){
                    return i;
                }
            }else if(pref[i - 1] == suff[i + 1]){
                return i;
            }
        }
        
        return -1;
    }
}
