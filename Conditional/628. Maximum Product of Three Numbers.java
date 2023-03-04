class Solution {
    public int maximumProduct(int[] nums) {
        
        //TC : O(nlogn)
        // Arrays.sort(nums); //sort the array so that max 3 num will be at right
        // int len = nums.length;
        // int a = nums[len - 1] * nums[len - 2] * nums[len - 3]; //3 largest num at right
        // int b = nums[0] * nums[1] * nums[len - 1]; //2 bigger negative no at left and one number at right
        // return Math.max(a, b); //return max of two
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int curr : nums){
            if(curr > max1){
                max3 = max2;
                max2 = max1;
                max1 = curr;
            }else if(curr > max2){
                max3 = max2;
                max2 = curr;
            }else if(curr > max3){
                max3 = curr;
            }
            
            if(curr < min1){
                min2 = min1;
                min1 = curr;
            }else if(curr < min2){
                min2 = curr;
            }
        }
        
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
