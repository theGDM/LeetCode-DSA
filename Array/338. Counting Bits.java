//Since th maximum value of n can be 10^5
//And number of digits int n is given by : floor(log10(n)) + 1
// worst case : n * logn
class Solution {
    //brute force
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 0; i <= n; ++i){
            int num = decimalToBinaryCoverter(i);
            res[i] = num;
        }
        return res;
    }
    
    public int decimalToBinaryCoverter(int n){
        int res = 0;
        int mul = 1;
        int noOfOne = 0;
        while(n > 0){
            int rem = n % 2;
            if(rem == 1){
                noOfOne++;
            }
            n = n / 2;
            res = res + rem * mul;
            mul = mul * 10;
        }
        
        return noOfOne;
    }
}
