//left array ka bade se bada, right ke chhote se bhi chhota hona chahiye
//using two arrays solution
//TC : O(n);
//SC : O(n);
class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] maxLeft = new int[nums.length];
        int[] minRight = new int[nums.length];
        
        //max upto i, max prefix array
        maxLeft[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }
        
        minRight[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; --i){
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }
        
        for(int i = 0; i < nums.length - 1; ++i){
            if(maxLeft[i] <= minRight[i + 1]){
                return i + 1;
            }
        }
        
        return -1;
    }
}


//left array ka bade se bada, right ke chhote se bhi chhota hona chahiye
//using single arrays solution
//TC : O(n);
//SC : O(n);
//Keep in mind we need to find the first max <= minRight[i], traversing from left
class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] maxLeft = new int[nums.length];
        int[] minRight = new int[nums.length];
        
       
        
        minRight[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; --i){
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; ++i){
            max = Math.max(max, nums[i]);
            if(max <= minRight[i + 1]){
                return i + 1;
            }
        }
        
        return -1;
    }
}


//TC : O(n);
//SC : O(1);

class Solution {
    public int partitionDisjoint(int[] nums) {
        int pi = 0;
        int mts = nums[0]; //max till scan
        int mtp = nums[0]; //max till partition
        
        for(int i = 1; i < nums.length; ++i){
            mts = Math.max(mts, nums[i]);
            
            if(nums[i] < mtp){
                pi = i;
                mtp = mts;
            }
        }
        
            
        return pi + 1;
    }
}
