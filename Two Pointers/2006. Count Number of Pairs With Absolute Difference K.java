// [7,7,8,3,1,2,7,2,9,5]
// 6
class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int n : nums){
            int tar1 = n + k; //check if n + k exist or not
            if(map.containsKey(tar1) == true){
                ans += map.get(tar1);
            }
            
            int tar2 = (n - k); //like target is 6 and n = 2, then search -4, 8
            if(map.containsKey(tar2) == true){
                ans += map.get(tar2);
            }
            
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        return ans;
    }
}


// [7,7,8,3,1,2,7,2,9,5]
// 6
class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int count = 0;
        for(int key : map.keySet()){
            int f1 = map.get(key);
            
            if(k == 0){ //never reach at this statement, as k >= 1
                count += f1 * (f1 - 1) / 2;
            }else{
                int f2 = map.getOrDefault(key + k, 0);
                count += f1 * f2;
            }
        }
        
        return count;
    }
}
