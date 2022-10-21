class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int key : map.keySet()){
            if(map.get(key) >= 2) return true;
        }
        
        return false;
    }
}

//TC : O(N)
//SC : O(N)
//Using SET
//Single Loop Traversal
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
		for(int num : nums){
            if(set.contains(num)) return true;
            else set.add(num);
        }
        
        return false;
    }
}

