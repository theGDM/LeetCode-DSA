//Acuired and release startegy
//TC : O(n) //SC : O(1)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0; //include pointer
        int j = 0; //exclude pointer
        
        int cz = 0; //count of zeros
        int res = 0; //result
        
        while(i < nums.length){
            if(nums[i] == 0){
                cz++;
            }
            
            while(cz > k){
                if(nums[j] == 0){
                    cz--;
                }
                j++;
            }
            
            int len = i - j + 1;
            res = Math.max(res, len);
            i++;
        }
        
        return res;
    }
        
}
