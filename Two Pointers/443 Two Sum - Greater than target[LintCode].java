//O(nlogn) + o(n)
//fixing the right element, and finding its all the pairs, on the right
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                left++;
            } else {
               count += right - left;
               right--;
            }
        }
        return count;
    }
}
