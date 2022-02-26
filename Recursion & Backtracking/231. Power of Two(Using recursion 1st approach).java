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
        //edge case
        if(n == 0) return false;
        
        int x = (int)Math.floor(Math.log(n) / Math.log(2));
        int res = power(2, x);
        if(res == n) return true;
        else return false;
    }
    
    public int power(int n, int x){
        //base case
        if(x == 0) return 1;

        //faith call
        int pxm1 = power(n, x / 2);
        
        //meeting expectation with faith
        if(x % 2 == 0){
            return pxm1 * pxm1;
        }else{
            return pxm1 * pxm1 * n;
        }
    }
}
