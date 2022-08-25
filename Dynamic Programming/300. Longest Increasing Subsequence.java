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

//TC : nlog(n)
//Har length ki Longest increasing subsequence ka, last value store karke rakh rahe hai
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 1;
        tails[0] = nums[0];
        
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] > tails[len - 1]){
                len++; //increase the length, and place the value
                tails[len - 1] = nums[i];
            }else{
                int idx = Arrays.binarySearch(tails, 0, len - 1, nums[i]); //it will give the position if
                if(idx < 0){ //that element found, otherwise, return the -ve indx, at which positon it 
                    idx = -idx; //should be placed..
                    idx = idx - 1;
                }
                
                tails[idx] = nums[i];
            }
        }
        
        return len;
    }
}
