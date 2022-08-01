//brute force approach O(n * n)
class Solution {
    public int waysToMakeFair(int[] nums) {
        int ridx = 0;
        int count = 0;
        for(int i = 0; i < nums.length; ++i){
            int even = 0;
            int odd = 0;
            for(int j = 0; j < nums.length; ++j){
                if(j == i){
                   continue; 
                }else if(j < i){
                    if(j % 2 == 0){
                        even += nums[j];
                    }else{
                        odd += nums[j];
                    }
                }else if(j > i){
                    if(j % 2 == 1){
                        even += nums[j];
                    }else{
                        odd += nums[j];
                    }
                }
            }
            
            // System.out.println(i + " -> " + even + " - " + odd);
            if(even == odd) count++;
        }
        
        return count;
    }
}
