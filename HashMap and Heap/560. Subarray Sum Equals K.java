class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int res = 0;
        hm.put(0, 1);//initially 0 sum to tha hi
        for(int n : nums){
            sum += n;
            int remSum = sum - k;
            if(hm.containsKey(remSum) == true){
                res += hm.get(remSum);
            }
            
            if(hm.containsKey(sum) == true){
                hm.put(sum, hm.get(sum) + 1);
            }else{
                hm.put(sum, 1);
            }
        }
      
        return res;
    }
}
