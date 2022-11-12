class Complete{
    
    //TC : O(N)
    // Function for finding maximum and value pair
    public static int minSwaps (int nums[], int n) {
        int win = 0;
        for(int num : nums){
            if(num == 1) win++;
        }
        
        if(win == 0) return -1;
    
        int minSwaps = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int cone = 0; //count of ones
        while(r < nums.length){
            if(nums[r] == 1){
                cone++;
            }
            
            if(r - l + 1 > win){ //if window size has incresed beyond win, then, make it size of win
                if(nums[l] == 1){
                    cone--;
                }
                l++;
            }
            
            if(r - l + 1 == win){
                int currentWinSwapNeed = win - cone; //swaps needed to make all ones in current window
                if(currentWinSwapNeed < minSwaps){
                     minSwaps = currentWinSwapNeed;
                }
            }
            r++;
        }
        
        return minSwaps;
    }
}


