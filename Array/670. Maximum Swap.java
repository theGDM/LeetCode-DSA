//matlab ham iss question me yah kar rahe hai hai ki, jo bhi num hai, uske ek position aange se
//jo bhi usses bada hai, uska index rakh le rahe hai;
class Solution {
    public int maximumSwap(int num) {
        char[] nums = (num + "").toCharArray();
        int n = nums.length;
        int[] maxfr = new int[nums.length];
        
        for(int j = n - 1; j >= 0; --j){
            if(j == n - 1){
                maxfr[j] = -1;
            }else if(j == n - 2){
                maxfr[j] = j + 1;
            }else{
                if(nums[j + 1] - '0' > nums[maxfr[j + 1]] - '0'){
                    maxfr[j] = j + 1;
                }else{
                    maxfr[j] = maxfr[j + 1];
                }
            }
        }
        
        for(int i = 0; i < nums.length - 1; ++i){
            if(nums[i] < nums[maxfr[i]]){
                char ch = nums[i];
                nums[i] = nums[maxfr[i]];
                nums[maxfr[i]] = ch;
                break;
            }
        }
        
        return Integer.parseInt(new String(nums));
    }
}
