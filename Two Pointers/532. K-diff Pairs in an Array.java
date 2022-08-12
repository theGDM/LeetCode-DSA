class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        
        int l = 0; int r = 1;
        int count = 0;
        while(l < nums.length && r < nums.length){
            if(l > 0 && nums[l] == nums[l - 1]){ //to avoid duplicacies
                l++; continue;
            }
            
            //when both pointer reaches to the same index
            if(l == r){
                r++; continue;
            }
            
            if(nums[r] - nums[l] < k){
                r++;
            }else if(nums[r] - nums[l] > k){
                l++;
            }else{
                count++;
                l++; //update left
            }
        }
        
        return count;
    }
}
