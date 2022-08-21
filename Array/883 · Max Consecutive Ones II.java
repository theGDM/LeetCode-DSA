public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */

    //acuired realese startegy 
    //TC : O(n)
    //SC : O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        int cz = 0;
        int i = 0; //acquire pointer
        int j = 0; //release pointer
        int ans = 0; //final result
        while(i < nums.length){
            if(nums[i] == 0){
                cz++;
            }
            
            //if number of 0's are greater than threshold, make it valid by moving j pointer
            while(j < i && cz > 1){
                if(nums[j] == 0){
                    cz--;
                }
                j++;
            }

            int len = i - j + 1;
            System.out.println(len);
            ans = Math.max(ans, len);
            i++;
        }

        return ans;
    }
}
