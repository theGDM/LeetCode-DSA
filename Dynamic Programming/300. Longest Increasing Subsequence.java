//LIS (Important category)
//TC : O(n2)
//arr[i] per khade hokar ye puchh rahe hai ki, arr[i], ko include karte hue maximum longest increasing 
//subsequece kya hoga
//jinke peeche lag sakta hai, unki lis value ka maximum liya, lis[i] me max + 1 add kar diya
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;
        
        for(int i = 1; i < nums.length; ++i){
            int max = 0;
            for(int j = 0; j < i; ++j){
                if(nums[j] < nums[i]){
                    max = Math.max(max, lis[j]);
                }
            }
            
            lis[i] = max + 1;
        }
        
        int res = 0;
        for(int i = 0; i < lis.length; ++i){
            res = Math.max(res, lis[i]);
        }

        return res;
    }
}

//TC : O(2^N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        return helper(0, -1, nums);
    }
    
    public int helper(int curr, int prev, int[] nums){
        if(curr == nums.length) return 0;
        
        int yes = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            yes = helper(curr + 1, curr, nums) + 1;
        }
        int no = helper(curr + 1, prev, nums);
        
        return Math.max(yes, no);
    }
    
}
