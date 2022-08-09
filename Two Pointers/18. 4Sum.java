//Brute Force O(n4)
//Normal = nested loops + two pointers = O(n3)
//Iterative

// [1000000000,1000000000,1000000000,1000000000]
// -294967296

// [-1000000000,-1000000000,1000000000,-1000000000,-1000000000]
// 294967296
class Solution {
    public List<List<Integer>> twoSum(int left, int right, int target, int[] nums){
        int start = left;
        List<List<Integer>> res = new ArrayList<>();
        while(left < right){
            if(left > start && nums[left] == nums[left - 1]){
                left++;
                continue;
            }
            
            int sum = nums[left] + nums[right];

            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                List<Integer> part = new ArrayList<>();
                part.add(nums[left]);
                part.add(nums[right]);
                
                res.add(part);
                left++;
                right--;
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int f = 0; f < nums.length - 3; f++){
            if(f > 0 && nums[f] == nums[f - 1]){ //avoid duplicates
                continue;
            }
            
            int first = nums[f];
            int t1 = target - first;
            
            for(int s = f + 1; s < nums.length - 2; s++){
                if(s > f + 1 && nums[s] == nums[s - 1]){ //avoid duplicates
                    continue;
                }
                
                int second = nums[s];
                if((long)t1 - second < Integer.MIN_VALUE || (long)t1 - second > Integer.MAX_VALUE){
                    break; //avoid overflow   
                }

                int t2 = t1 - second;
        
                List<List<Integer>> part = twoSum(s + 1, nums.length - 1, t2, nums);
                
                for(List<Integer> quad : part){
                    quad.add(0, second);
                    quad.add(0, first);
                    
                    res.add(quad);
                }
            }
        }
        
        return res;
    }
}

//Brute Force O(n4)
//Recursive approch // TC = O(n ^ (k - 1))
class Solution {
    public List<List<Integer>> twoSum(int left, int target, int[] nums){
        int start = left;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while(left < right){
            if(left > start && nums[left] == nums[left - 1]){
                left++;
                continue;
            }
            
            int sum = nums[left] + nums[right];

            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                List<Integer> part = new ArrayList<>();
                part.add(nums[left]);
                part.add(nums[right]);
                
                res.add(part);
                left++;
                right--;
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> kSum(int start, int target, int[] nums, int k){
        if(k == 2){
            return twoSum(start, target, nums);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = start; i <= nums.length - k; i++){
            if(i > start && nums[i] == nums[i - 1]) continue; //skip duplicates
            
            //important
            if((long)target - nums[i] < Integer.MIN_VALUE || (long)target - nums[i] > Integer.MAX_VALUE){
                return new ArrayList<>(); //avoid overflow   
            }
            //sub result
            List<List<Integer>> subRes = kSum(i + 1, target - nums[i], nums, k - 1);
            
            for(List<Integer> sub : subRes){
                sub.add(0, nums[i]);
                res.add(sub);
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(0, target, nums, 4);
    }
}
