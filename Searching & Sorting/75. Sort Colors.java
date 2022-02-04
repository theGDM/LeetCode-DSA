class Solution {
    public void swap(int[] arr, int p, int q){
        int tempData = arr[p];
        arr[p] = arr[q];
        arr[q] = tempData;
    }
    //DNF Sort
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while(j <= k){
            if(nums[j] == 0){
                swap(nums, i, j);
                ++i;
                ++j;
            }else if(nums[j] == 1){
                ++j;
            }else{
                swap(nums, j, k);
                --k;
            }
        }
    }
}
