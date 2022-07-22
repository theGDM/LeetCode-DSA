class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); //nlogn
        int median = nums[nums.length / 2]; //get median
        int minMoves = 0;
        
        for(int i = 0;i < nums.length; ++i){
            minMoves += Math.abs(nums[i] - median);
        }
        
        return minMoves;
    }
}
