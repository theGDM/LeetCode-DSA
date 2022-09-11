//TC : O(n)
//SC : O(1)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostKOddNumbers(nums, k) - atMostKOddNumbers(nums, k - 1);
    }
    
    public int atMostKOddNumbers(int[] nums, int k){
        HashMap<Integer, Integer> freq = new HashMap<>();
        int l = 0, odd = 0;
        int count = 0;
        for(int r = 0; r < nums.length; ++r){
            if(nums[r] % 2 == 1) odd++;
            
            if(odd > k){
                while(l <= r && odd > k){ //l <= r is important, TC : [1,1,1,1,1], K = 1
                    if(nums[l] % 2 == 1){
                        odd--;
                        
                    }
                    l++;
                }
            }
            
            count += (r - l + 1);   
        }
        
        return count;
    }
}
