//TC : O(2n)
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int l = 0, maxLen = 0;
        int maxSum = 0;
        int currSum = 0;
        for(int r = 0; r < nums.length; ++r){
            int num = nums[r];
            currSum += num;
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            
            while(freq.get(num) > 1){ //tab tak map se remove karte jao, jab tak, ch ka count 1 nahi ho jata
                int numl = nums[l];
                currSum -= numl;
                freq.put(numl, freq.get(numl) - 1);
                l++;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}
