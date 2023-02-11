//TC : O(N)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int curr = 0, max = 0;
        for(int i = 0; i < nums.length; ++i){
            if(i > 0 && nums[i - 1] < nums[i]){
                curr++;
            }else{
                curr = 1;
            }
            
            max = Math.max(max, curr);
        }
        
        return max;
    }
}

//Printing
//TC : O(N * N)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int curr = 0, max = 0;
        ArrayList<Integer> currList = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            if(i > 0 && nums[i - 1] < nums[i]){
                curr++;
                currList.add(nums[i]);
            }else{
                curr = 1;
                currList = new ArrayList<>();
                currList.add(nums[i]);
            }
            
            if(currList.size() > res.size()){
                res = new ArrayList(currList);
            }
            max = Math.max(max, curr);
        }
        System.out.println(res);
        return max;
    }
}
