class Solution {
    List<List<Integer>> combination;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combination = new ArrayList<>();
        helperSum(0, target, candidates, new ArrayList<>());
        return combination;
    }
    
    public void helperSum(int idx, int tar, int[] candidates, List<Integer> comb){
        if(idx == candidates.length){
            if(tar == 0){
                combination.add(new ArrayList(comb));
            }
            return;
        }
        
        if(tar - candidates[idx] >= 0){
            comb.add(candidates[idx]);
            helperSum(idx, tar - candidates[idx], candidates,comb); //call-1
            comb.remove(comb.size() - 1);
        }
        helperSum(idx + 1, tar, candidates,comb); //call-2
        
        return;
    }
}
