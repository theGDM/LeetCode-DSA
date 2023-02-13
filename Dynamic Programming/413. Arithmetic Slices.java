//TC : O(N)
//SC : O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0; //edge case
        
        int count = 0;
        int currDiff = nums[1] - nums[0];
        int currLength = 2;
        for(int i = 2; i < nums.length; ++i){
            if(nums[i] - nums[i - 1] == currDiff){
                currLength++;
            }else{
                currDiff = nums[i] - nums[i - 1];
                currLength = 2;
            }  
            
            if(currLength >= 3){
                count = count + (currLength - 2);
            }
        }
        
        return count;
    }
}

//my way
//TC : O(N)
//SC : O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0; //edge case
        
        int count = 0;
        int currDiff = nums[1] - nums[0];
        int currLength = 2;
        for(int i = 2; i < nums.length; ++i){
            if(nums[i] - nums[i - 1] == currDiff){
                currLength++;
            }else{
                if(currLength >= 3){
                    count += calculateSlices(currLength);
                }
                
                currDiff = nums[i] - nums[i - 1];
                currLength = 2;
            }
        }
    
        if(currLength >= 3){
            count += calculateSlices(currLength);
        }
        
        return count;
    }
    
    public int calculateSlices(int n){
        int ans = ((n - 2) * (n - 1)) / 2;
        return ans;
    }
}
