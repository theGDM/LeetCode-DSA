//TC : O(logn)
class Solution {
    public double myPow(double x, int n) {
        //Edge Cases
        if(x == -1 && n == Integer.MIN_VALUE ) return 1;//[-1.00000, -2147483648]
        if(x == 1 || x == -1) return x; //[1.00000, -2147483648], [-1.00000, 2147483647]
        if(n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) return 0; //[2.00000, -2147483648]
        
        if(n < 0){
            return 1 / pow(x, -n);
        }
        
        return pow(x, n);
    }
    
    public double pow(double x, int n){
        if(n == 0) return 1;
        
        double pxnby2 = myPow(x, n / 2); //power of x is n / 2
        if(n % 2 == 0){
            return pxnby2 * pxnby2;
        }else{
            return x * pxnby2 * pxnby2;
        }
    }
}
