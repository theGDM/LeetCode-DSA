//Time complexity : nlog(n) + o(n) ~ o(nlog(n))
//space complexity : o(n)
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        while(l < r){
            if(nums[l] + nums[r] > k){
                r--;
            }else if(nums[l] + nums[r] < k){
                l++;
            }else{
                count++;
                l++;
                r--;
            }
        }
        
        return count;
    }
}

//Time complexity : o(n)
//space complexity : o(n)
// We gonna fill our map as frequency map. And we gonna get the result by subtracting current value from k & whatever result we get, we gonna check in our map. If that is present increment the count & remove it from the map now. That's how we'll get our answer in just O(1) for searching & as we are using a loop thus, O(N). But it's a good approach.

//exapmle : 1 1 2 2 2 3 3 4 4 4 5 5 6
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>(); //frequency map
        int count = 0;
        
        for(int i = 0; i < nums.length; ++i){
            int rem = k - nums[i];
            
            if(hm.containsKey(rem) == true){
                count++;
                
                if(hm.get(rem) == 1) hm.remove(rem);
                else hm.put(rem, hm.get(rem) - 1);
            }else{
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            }
        }
        
        return count;
    }
}
