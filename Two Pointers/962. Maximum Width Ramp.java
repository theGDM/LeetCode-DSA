//Classical two pointer problem. j pointer expands the range and i pointer contracts it. The trick is that i pointer iterates over original array and j pointer iterates over an array which stores maximum no. on the right for each index.
//O(n)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] maxr = new int[nums.length]; //suffix max array
        
        maxr[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; --i){
            maxr[i] = Math.max(maxr[i + 1], nums[i]);
        }
        
        int j = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; ++i){
            int a = nums[i];
            
            while(j < maxr.length && a <= maxr[j]){ //jaha tak ja sakte ho chale jao, means move j pointer
                ans = Math.max(ans, j - i);
                j++;
            }
        }
        
        return ans;
    }
}


//Classical two pointer problem. j pointer expands the range and i pointer contracts it. The trick is that i pointer iterates over original array and j pointer iterates over an array which stores maximum no. on the right for each index.
//O(n)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] maxr = new int[nums.length]; //suffix max array
        
        maxr[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; --i){
            maxr[i] = Math.max(maxr[i + 1], nums[i]);
        }
        
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i < nums.length){
            int a = nums[i];
            
            while(j < maxr.length && a <= maxr[j]){ //jaha tak ja sakte ho chale jao, means move j pointer
                j++;
            }
            
            ans = Math.max(ans, j - i - 1);
            i++;
        }
        
        return ans;
    }
}
