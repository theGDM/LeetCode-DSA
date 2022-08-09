public class Solution {
    /**
     * @param nums:  an array of n integers
     * @param target: a target
     * @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
     */

    //It allows duplicate elemen to count.. 
    public int twoSumSmaller(int left, int right,  int[] nums, int target){
        int count = 0;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum < target){
                count += right - left;
                left++;
            }else if(sum >= target){
                right--;
            }
        }

        return count;
    }

    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }

        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; ++i){
            ans += twoSumSmaller(i + 1, nums.length - 1, nums, target - nums[i]);
        }

        return ans;
    }
}
