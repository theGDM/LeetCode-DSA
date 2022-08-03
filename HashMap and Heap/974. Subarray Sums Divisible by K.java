//O(n)
//Example : 2, 3, 5, 4, 5, 3, 4  : k = 7
//Example : 2, -6, 3, 1, 2, 8, 2, 1 : k = 7
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int rem = 0;
        int sum = 0;
        for(int n : nums){
            sum += n;
            rem = sum % k;
            
            if(rem < 0){
                rem += k;
            }
            
            if(map.containsKey(rem) == true){
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }else{
                map.put(rem, 1);
            }
                        
        }
        
        return ans;
    }
}
