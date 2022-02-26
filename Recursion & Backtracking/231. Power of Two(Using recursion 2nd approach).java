// Given an integer n, return true if it is a power of two. Otherwise, return false.

// An integer n is a power of two, if there exists an integer x such that n == 2x.

 

// Example 1:

// Input: n = 1
// Output: true
// Explanation: 20 = 1
// Example 2:

// Input: n = 16
// Output: true
// Explanation: 24 = 16
// Example 3:

// Input: n = 3
// Output: false

class Solution {
    public boolean isPowerOfTwo(int n) {
        return helper(n,0);
    }
    
    public boolean helper(int n,int x){
        if(x >= 31){ //base case
            return false;
        }
        //meeting expectation
        if((int)(Math.pow(2,x))==n){
            return true;
        }
        //faith call
        return helper(n,x+1);
    }
}
