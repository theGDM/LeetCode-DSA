//3 sum unique
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
    
            int target = 0 - nums[i];
            
            int left = i + 1;
            int right = nums.length - 1;
        
            while(left < right){
                if(left > i + 1 && nums[left] == nums[left - 1]){ //avoid the same previous nums[left]
                    left++;
                    continue;
                }
                
                int sum = nums[left] + nums[right];
                
                if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }else{
                    // System.out.println(i + " " + left + " " + right + " " + target);
                    res.add(new ArrayList(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                }
            }
        }
        
        return res;
    }
}
