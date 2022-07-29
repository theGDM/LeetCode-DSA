//We only care about the subsequences and max/min values, so the order of the elements does not matter. Therefore, we sort the array at first.
class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long modulo = (long)Math.pow(10, 9) + 7;
        long ans = 0;
        long p = 1;
        
        for(int i = 0, j = nums.length - 1; i < nums.length && j >= 0; ++i, --j){
            ans = (ans + (p * nums[i] - p * nums[j])) % modulo;
            p = (p * 2) % modulo;
        }
        
        return (int)ans;
    }
}
