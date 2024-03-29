// Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.
// Example 1:

// Input: n = 5
// Output: 2
// Explanation: 5 = 2 + 3
// Example 2:

// Input: n = 9
// Output: 3
// Explanation: 9 = 4 + 5 = 2 + 3 + 4
// Example 3:

// Input: n = 15
// Output: 4
// Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 

//TC : O(sqrt(n))
//TC : O(sqrt(n))
//consecutive numbers are positive
// kx = n - k * ( k - 1)/2
//first condition -> k = number of terms (always greater than equal to 1)
                   //x = starting number(it must be natural number)
//so kx > 0
class Solution {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        int k = 1; //number of terms
        int check = k * (k - 1) / 2;
        
        while(check < n){
            if((n - check) % k == 0){
                res++;
            }
            
            k++; //incraese the num. of terms
            check = k * (k - 1) / 2; //update check
        }
        
        return res;
    }
}
