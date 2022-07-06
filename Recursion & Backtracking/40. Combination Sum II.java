// if (i > cur && cand[i] == cand[i-1]) continue; This can avoid the duplicates.
// Our path array contains some element which picked from cand[0...cur-1].
// We start from i=cur, now it is i> cur, which means we already tried the elements between cur to i-1 (i-1>=cur).
// Now we are in candidate[i] and candidate[i]==candidate[i-1]. Now need to try another time.

class Solution {
    List<List<Integer>> combination;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combination = new ArrayList<>();
        helperSum(0, target, candidates, new ArrayList<>());
        return combination;
    }
    
    public void helperSum(int curr, int target, int[] candidates, List<Integer> comb){
        if(target == 0){
            combination.add(new ArrayList(comb));
            return;
        }
        
        for(int i = curr; i < candidates.length; ++i){
            if(i > curr && candidates[i] == candidates[i - 1]){ //save from duplicates
                continue; 
            }
            
            if(target - candidates[i] >= 0){
                comb.add(candidates[i]);
                helperSum(i + 1, target - candidates[i], candidates, comb); //call-1
                comb.remove(comb.size() - 1);
            }else{
                break;
            }
        }
        
        return;
    }
}
