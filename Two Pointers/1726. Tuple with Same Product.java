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

// TC: O(n2)
// To get the solution we have to choose 2 equal products ( Since a * b = c * d ) (a * b = first pair and c * d = second pair)
// nC2 = n * (n - 1) / 2
// Then we have to multiply this by 8 because a possible sequence can have 8 arrangements

class Solution {
    public int tupleSameProduct(int[] nums) {
        if(nums.length < 0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0;i < nums.length; ++i){
            for(int j = i + 1; j < nums.length; ++j){
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        
        int res = 0;
        for(int prod : map.keySet()){
            int freq = map.get(prod);
            if(freq > 1){
                res += (freq * (freq - 1) / 2) * 8;
            }
        }
        
        return res;
    }
}
