//TC : O(2n)
//SC : O(k)
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKUniqueChar(nums, k) - atMostKUniqueChar(nums, k - 1);
    }
    
    public int atMostKUniqueChar(int[] nums, int k){
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int l = 0;

        for(int r = 0; r < nums.length; ++r){
            int num = nums[r];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            
            while(freq.size() > k){
                int numl = nums[l];
                if(freq.get(numl) == 1){
                    freq.remove(numl);
                }else{
                    freq.put(numl, freq.get(numl) - 1);
                }
                l++;
            }
                
            count += (r - l + 1); //atmost k unique
        }

        return count;
    } 
        
}
