//TC : O(n2)
//Normal loop from back which will make 3rd side + two sum greater
//count duplicates too...
class Solution {
    public int twoSumGreater(int left, int right, int c, int[] nums){
        int count = 0;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum <= c){
                left++;
            }else{
                count += right - left;
                right--;
            }
        }
        
        return count;
    }
    
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = nums.length - 1; i >= 2; --i){
            int c = nums[i];
            ans += twoSumGreater(0, i - 1, c, nums);
        }
        
        return ans;
    }
}
