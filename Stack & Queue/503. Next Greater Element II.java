//O(n2) solution which will give the tle
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //first approach whenever there comes a circular problem, we extent the array to twice the size;
        int n = nums.length;
        int[] temp = new int[2 * n]; //temp array twice the original nums array
        int[] result = new int[n];
        
        //finding the maximum value
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i){
            max = Math.max(max, nums[i]);
        }
        
        for(int i = 0; i < 2 * n; ++i){
            temp[i] = nums[i % n];
        }
        
        for(int i = 0; i < n; ++i){
            result[i] = -1; //initially put -1, as nge
            if(temp[i] == max){ //as we know that max element can not have the next greater element, so cont.
                continue;
            }
            
            for(int j = i + 1; j < 2 * n; ++j){
                if(temp[j] > temp[i]){
                    result[i] = temp[j];
                    break;
                }
            }
        }
        
        return result;
    }
}

//O(n2) solution which may give the tle
//Carefull bruteforce approach
//traversing circularly
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //first approach whenever there comes a circular problem, we extent the array to twice the size;
        int n = nums.length;
        int[] result = new int[n];
        
        for(int i = 0; i < n; ++i){
            result[i] = -1; //initially put -1, as nge
            
            for(int j = 1; j < n; ++j){
                if(nums[(i + j) % n] > nums[i]){
                    result[i] = nums[(i + j) % n];
                    break;
                }
            }
        }
        
        return result;
    }
}

//stack based solution
//time complexity : O(2n), in worst removing all the elements from the stack
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        
        //so that we have access to the arrays value, from back,
        //as smaller index will be on the top
        for(int i = nums.length - 1; i >= 0; --i){
            stk.push(i);
        }
        
        int[] result = new int[nums.length];
        
        for(int i = nums.length - 1; i >= 0; --i){
            while(stk.size() > 0 && nums[i] >= nums[stk.peek()]){
                stk.pop();
            }
            
            if(stk.size() > 0){
                result[i] = nums[stk.peek()];
            }else{
                result[i] = -1;
            }
            
            stk.push(i);
        }
        
        return result;
    }
}
