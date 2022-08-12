//O(n) solution
class Solution {
    public int countPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; ++i){
            int n = nums[i];
            if(map.containsKey(n) == false){
                map.put(n, new ArrayList<>());
            }else{
                for(int j : map.get(n)){ //arrylist of indices
                    if(i * j % k == 0){
                        res++;
                    }
                } 
            }
            
            map.get(n).add(i); //finally add the current elements index
        }
        return res;
    }
}
