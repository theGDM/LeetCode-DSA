//TC : O(N * N), N is the size of stones array
class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < stones.length; ++i){
            int stonePresentIdx = stones[i];
            map.put(stonePresentIdx, new HashSet<>());
        }
        
        map.get(0).add(1);
        
        for(int i = 0; i < stones.length; ++i){
            int stonePresentIdx = stones[i];
            HashSet<Integer> jumps = map.get(stonePresentIdx);
    
            for(int jump : jumps){
                int reachPosition = stonePresentIdx + jump; //reaching position
                if(map.containsKey(reachPosition) == true){//checking are we landing on stone or not
                    if(jump - 1 > 0) map.get(reachPosition).add(jump - 1);
                    map.get(reachPosition).add(jump);
                    map.get(reachPosition).add(jump + 1);
                }
            }
        }

        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
