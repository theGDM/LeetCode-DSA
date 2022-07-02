//it is simple recursion and backtracking problem, here we have to use the concept of box on level.
//That means on every level the output size will be same, and each box will explore its choices.
//If we chose any element than that won't appear in the next box of output string.
//SC : O(n! * n);
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        getPermutation(0, nums, new ArrayList<>());
        return res;
    }
    
    public void getPermutation(int idx, int[] nums, List<Integer> permute){
        if(nums.length == 0){
            res.add(new ArrayList(permute));
            return;
        }
        
        for(int i = 0; i < nums.length; ++i){
            int[] newNums = new int[nums.length - 1];
            int k = 0;
            
            for(int j = 0; j < nums.length; ++j){
                if(j != i){
                    newNums[k++] = nums[j];
                }
            }
            
            permute.add(nums[i]);
            getPermutation(idx + 1, newNums, permute);
            permute.remove(permute.size() - 1); //backtrack
        }
    }
}
