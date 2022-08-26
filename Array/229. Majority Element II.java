class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;
        
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        
        // System.out.println(candidate1 + " " + candidate2);
        
        //Now verify that the candidate 1 and candidate 2 are in actually the majority element or not
        count1 = 0;
        count2 = 0;
        for(int val: nums){
            if(val == candidate1){
                count1++;
            } else if(val == candidate2){
                count2++;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(count1 > nums.length / 3){
            ans.add(candidate1);
        }
        
        if(count2 > nums.length / 3){
            ans.add(candidate2);
        }
        
        return ans;
    }
}
