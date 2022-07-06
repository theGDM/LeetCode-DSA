class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        getPermutation(0, nums, new ArrayList<>());
        return res;
    }
    
    public void getPermutation(int idx, int[] nums, List<Integer> permute){
        if(nums.length == 0){
            res.add(new ArrayList(permute));
            return;
        }
        
        for(int i = 0; i < nums.length; ++i){
            if(i - 1 >= 0 && nums[i] == nums[i - 1]){ //if current nums value equal to prev nums value, then continue
                continue;                             //, as permutaion of this combination is already obtained.
            }
            
            //making the newNums array that do not include the used index value
            int[] newNums = new int[nums.length - 1];
            int k = 0;
            
            for(int j = 0; j < nums.length; ++j){
                if(j != i){
                    newNums[k++] = nums[j];
                }
            }
            
            //add the value in edge preorder
            permute.add(nums[i]);
            getPermutation(i + 1, newNums, permute);
            permute.remove(permute.size() - 1); //backtrack
        }
    }
}
