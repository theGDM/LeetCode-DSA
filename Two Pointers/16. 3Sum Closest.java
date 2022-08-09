//Normal loop + two sum closest
//O(n2)
class Solution {
    public int twoSumClosest(int left, int right, int target, int[] nums){
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        while(left < right){
            int sum = nums[left] + nums[right];
            
            if(sum < target){
                if(diff > target - sum){
                    diff = target - sum;
                    ans = sum;
                }
                
                left++;
            }else if(sum > target){
                 if(diff > sum - target){
                    diff = sum - target;
                    ans = sum;
                }   
                
                right--;
            }else{ //sum == target
                return sum;
            }
        }
        
        return ans;
    }
    
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2 ; ++i){
            int curr = twoSumClosest(i + 1, nums.length - 1, target - nums[i], nums) + nums[i];
            if(Math.abs(target - curr) < diff){
                diff = Math.abs(target - curr);
                ans = curr;
            }
        }
        
        return ans;
    }
}
