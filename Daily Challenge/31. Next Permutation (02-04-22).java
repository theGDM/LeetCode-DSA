class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i , j);
            ++i;
            --j;
        }
    }
    
    public void nextPermutation(int[] nums) {
        //step 1 -> getting an element such that nums[i] < nums[i + 1]
        int fIdx = -1;
        int fNum = 0;
        for(int i = nums.length - 1; i >= 1; --i){
            if(nums[i] > nums[i - 1]){
                fNum = nums[i - 1];
                fIdx = i - 1;
                break;
            }
        }
        
        //base case
        if(fIdx == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        //step 2 -> getting an element such that which is greater that fNum
        int sIdx = 0;
        for(int i = nums.length - 1; i >= 1 + fIdx; --i){
            if(nums[i] > fNum){
               sIdx = i;
               break;
            }
        }
        
        //step 3 -> swap the element at idx fIdx and sIdx
        swap(nums, fIdx, sIdx);
        
        //step 4 -> reverse the array after fIdx
        reverse(nums, fIdx + 1, nums.length - 1);
    }
}
