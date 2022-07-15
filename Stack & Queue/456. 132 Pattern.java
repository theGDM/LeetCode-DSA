//O(n3) solution
class Solution {
    public boolean find132pattern(int[] nums) { 
        for(int i = 0; i < nums.length; ++i){
            for(int j = i + 1; j < nums.length; ++j){
                for(int k = j + 1; k < nums.length; ++k){
                    if(nums[i] < nums[k] && nums[j] > nums[k]){
                        System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

//Example : 1 2 1 6 3 8 9
//O(n2) solution
class Solution {
    public boolean find132pattern(int[] nums) { 
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < nums.length; ++j){
            min = Math.min(min, nums[j]);
            
            if(min == nums[j]) continue;
            
            for(int k = nums.length - 1; k > j; --k){
                if(min < nums[k] && nums[k] < nums[j]){
                    return true;
                }
            }
        }
        
        return false;
    }
}

//O(n) solution
class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length + 1];
        
        min[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            min[i] = Math.min(nums[i], min[i - 1]);
        }
        
        Stack<Integer> stk = new Stack<>();
        
        for(int j = nums.length - 1; j >= 0; --j){
            while(stk.size() > 0 && stk.peek() <= min[j]){
                stk.pop();
            }
            
            if(stk.size() > 0){
                if(stk.peek() < nums[j]){
                    return true;
                }
            }
            
            stk.push(nums[j]);
        }
        
        return false;
    }
}
