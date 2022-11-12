```
//TC : O(N + win)
//SC : O(2 * N)
class Solution {
    public int minSwaps(int[] nums) {
        int[] temp = new int[nums.length * 2];
        
        for(int i = 0; i < temp.length; ++i){
            temp[i] = nums[i % nums.length]; //Trick to Solve circular array problems, make array of size 2 * n
        }
        
        int win = 0;
        for(int num : nums){ //count all the 1's which will determine the size of window
            if(num == 1) win++;
        }
		
        if(win == nums.length) return 0; //No swaps required, as all 1s are already together
        int minSwaps = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int cone = 0; //count of ones
        while(r < nums.length + win){
            if(temp[r] == 1) cone++;
            
            if(r - l + 1 > win){ ////if window size has incresed beyond win, then, make it size of win
                if(temp[l] == 1) cone--;
                l++;
            }
            
            if(r - l + 1 == win){ //swaps needed to group all ones together in current window
                int currentWinSwapNeeded = win - cone;
                minSwaps = Math.min(minSwaps, currentWinSwapNeeded);
            }
            r++;
        }
        
        return minSwaps;
    }
}
```
