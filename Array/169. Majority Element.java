//Boyer-Moore Majority Vote Algorithm
class Solution {
    //approach 1
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    //approch 2
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == major){
                count++;
            }else{
                count--;
                
                if(count == 0){
                    major = nums[i];
                    count++;
                }
            }
        }
        
        return major;
    }
}
