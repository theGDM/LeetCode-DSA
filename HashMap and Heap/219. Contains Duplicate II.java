//Two Traversal Algo
//TC : O(N)
//SC: O(N), worst case, when all are different
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){ //O(N)
            int key = nums[i];
            if(map.containsKey(key) == false){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
        }

        for(int key : map.keySet()){
            ArrayList<Integer> list = map.get(key);
            if(list.size() == 1) continue;
            
            for(int i = 0; i < list.size() - 1; ++i){
                if(list.get(i + 1) - list.get(i) <= k){
                    return true;
                }
            }
        }
        
        return false;
    }
}

//Single Traversal Algo
//TC : O(N)
//SC: O(N), worst case, when all are different
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){ //O(N)
            int key = nums[i];
            if(map.containsKey(key)){
                if(i - map.get(key) <= k) return true;
            }
            map.put(key, i);
        }
        return false;
    }
}
