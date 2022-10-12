//TC : O(nlogn)
//SC : O(1)
//first of all sort the array, then apply the rules
class Solution {
    public int largestPerimeter1(int[] nums) {
        int maxPeri = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i){
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            
            if(a + b > c && b + c > a && a + c > b){
                int peri = a + b + c;
                if(peri > maxPeri){
                    maxPeri = peri;
                }
            }
        }
        
        return maxPeri;
    }
    
    public int largestPerimeter2(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 3; i >= 0; --i){
            if(nums[i] + nums[i + 1] > nums[i + 2]){
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        
        return 0;
    }
}

// This leads to a simple algorithm: Sort the array. For any c in the array, we choose the largest possible 
//a <= b <= c: these are just the two values adjacent to c. If this forms a triangle, we return the answer.
    
