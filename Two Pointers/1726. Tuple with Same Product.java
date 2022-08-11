//Gives TLE, and produce all the quads
class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        
        for(int i = 0;i < nums.length; ++i){
            for(int j = 0; j < nums.length; ++j){
                if(i == j) continue;
                
                int prod = nums[i] * nums[j];
                if(map.containsKey(prod) == false){
                    map.put(prod, new ArrayList<>());
                }
                
                map.get(prod).add(new ArrayList(Arrays.asList(i, j)));
            }
        }
        //[2, 3, 2, 3]
        int count = 0;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i < nums.length; ++i){
            for(int j = 0; j < nums.length; ++j){
                if(i == j) continue;
                
                int prod = nums[i] * nums[j];
                if(map.containsKey(prod) == false){
                    continue;
                }
                
                for(List<Integer> pair : map.get(prod)){
                    if(i != pair.get(0) && i != pair.get(1) && j != pair.get(0) && j != pair.get(1)){
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[pair.get(0)]);
                        quad.add(nums[pair.get(1)]);
                        
                        res.add(quad);
                    }
                }
            }
        }
        
        return res.size();
        
    }
}
