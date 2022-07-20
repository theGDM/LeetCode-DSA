//j ka kaam hai aange badhna
//i ka kaam hai, even ko collect karna
//0 - (i - 1) known area hai, jisme even collect ho rahe hai
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;
        
        while(j < nums.length){
            if(nums[j] % 2 == 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return nums;
    }
}
