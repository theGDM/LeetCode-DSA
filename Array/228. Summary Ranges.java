//O(N2)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            StringBuilder str = new StringBuilder(nums[i] + "");
            int j = 1;
            while(nums[i] != Integer.MAX_VALUE && set.contains(nums[i] + j)){
                j++;
            }
            
            if(nums[i] != nums[i] + j - 1){
                str.append("->" + (nums[i] + j - 1));
                res.add(str.toString());
            }else res.add(str.toString());
            
            i += j;
        }
        
        return res;
    }
}


//O(N2)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            int start = nums[i];
            while(i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1){
                i++;
            }
            
            if(start != nums[i]){
                res.add(start + "->" + nums[i]);
            }else{
                res.add(start + "");
            }
        }
        
        return res;
    }
}
