//TC : O(n)
//A number must have only, 2, 3, 5 as its prime factor
class Solution {
    public boolean isUgly(int n) {
        if (n == 0) return false;
        if (n == 1) return true; //1 = 2^0 * 3^0 * 5^0
        
        while(n % 2 == 0){
            n /= 2;
        }
        
        while(n % 3 == 0){
            n /= 3;
        }
        
        while(n % 5 == 0){
            n /= 5;
        }
        
        if(n == 1) return true;
        else return false;
    }
}
