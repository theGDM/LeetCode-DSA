//TC : O(2 * N)
//SC : O(N) 
class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            set.add(num);
        }
        
        for(int i = 0; i <= max; ++i){
            if(set.contains(i) == false) return i;
        }
        
        return nums.length;
    }
}

//O(1) space soultion is using Bit Manipulation
