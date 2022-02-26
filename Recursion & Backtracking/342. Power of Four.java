// Given an integer n, return true if it is a power of four. Otherwise, return false.

// An integer n is a power of four, if there exists an integer x such that n == 4x.

 

// Example 1:

// Input: n = 16
// Output: true
// Example 2:

// Input: n = 5
// Output: false
// Example 3:

// Input: n = 1
// Output: true

class Solution {
    public boolean isPowerOfFour(int n) {
        return helper(n, 0, 0);
    }
    
    public boolean helper(int n, int x, int currPower){
        if(currPower > n || x > 15){ //base case
            return false;
        }
        
        //meeting expectation
        currPower = (int)Math.pow(4, x);
        if(currPower == n){
            return true;
        }
        
        //faith call
        return helper(n, x + 1, currPower);
    }
}
