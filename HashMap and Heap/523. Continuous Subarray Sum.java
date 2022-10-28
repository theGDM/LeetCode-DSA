//TC : O(N)
//SC : O(N)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // initialize the hash map with index 0 for sum 0
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            // if the remainder (sum % k) occurs for the first time
            if(map.containsKey(rem) == false) map.put(rem, i);
            // if the subarray size is at least two
            else if(i - map.get(rem) >= 2) return true;
        }
        return false;
    }
}
