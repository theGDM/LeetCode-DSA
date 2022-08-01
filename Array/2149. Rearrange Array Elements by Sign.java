//Two pointer approach O(n) 
class Solution {
    public int[] rearrangeArray(int[] nums) {        
        int i = 0;
        int j = 0;
        int idx = 0;
        int[] res = new int[nums.length];
        while(i < nums.length && j < nums.length){
            
            while(nums[i] < 0) i++;
            while(nums[j] > 0) j++;
            
            res[idx++] = nums[i];
            res[idx++] = nums[j];
        
            i++;
            j++;
        }
        
        return res;
    }
}
