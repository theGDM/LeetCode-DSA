// Given an integer n, return true if it is a power of three. Otherwise, return false.

// An integer n is a power of three, if there exists an integer x such that n == 3x.

 

// Example 1:

// Input: n = 27
// Output: true
// Example 2:

// Input: n = 0
// Output: false
// Example 3:

// Input: n = 9
// Output: true

class Solution {
    public boolean isPowerOfThree(int n) {
       return helper(n, 0, 0); 
    }
    
    public boolean helper(int n, int x, int currPower){
        if(currPower > n || x >= 20){ //base case
            return false;
        }
        
        //meeting expectation
        currPower = (int)Math.pow(3, x);
        if(currPower == n){
            return true;
        }
        
        //faith call
        return helper(n, x + 1, currPower);
    }
}
