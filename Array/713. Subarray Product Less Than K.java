//1. The idea is always keep an max-product-window less than K;
//2. Every time shift window by adding a new number on the right(j), if the product is greater than k, then try to reduce numbers on the left(i), until the subarray product fit less than k again, (subarray could be empty);
//3. Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
// example:
// for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))

// I think the trickiest part is why the number of newly introduced subarrays is j - i + 1.
// Say now we have {1,2,3} and add {4} into it. Apparently, the new subarray introduced here are:
// {1,2,3,4}, {2,3,4}, {3,4}, {4}, which is the number of elements in the new list.
// If we also remove some at the left, say we we remove 1, then subarrays are:
// {2,3,4}, {3,4}, {4}. It is easy to get the result is j - i + 1.

//practice example : [3,5,7,2,3,1,4,2]  40

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;
        if(k == 1) return 0;
        
        int left = 0, right = 0;
        int prod = 1;
        int ans = 0;
        
        while(right < nums.length){
            prod *= nums[right];
            
            while(prod >= k){
                prod = prod / nums[left];
                left++;
            }
            
            ans += right - left + 1;
            right++;
        }
        
        return ans;
    }
}
