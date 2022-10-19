//TC : O(N)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){ //O(N), creating the hashmap
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1]; //O(N), putting in bucket
        for(int n : map.keySet()){
            int freq = map.get(n);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(n);
        }
        
        int[] res = new int[k]; //filling the res
        int idx = 0;
        for(int freq = buckets.length - 1; freq >= 0 && idx < k; --freq){
            if(buckets[freq] != null){
                for(int i = 0; i < buckets[freq].size() && idx < k; ++i){
                    res[idx++] = buckets[freq].get(i);
                }
            }
        }
        
        return res;
    }
}
