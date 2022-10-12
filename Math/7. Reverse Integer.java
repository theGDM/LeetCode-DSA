//TC : O(log10(x) + 1)
class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int rem = x % 10;
            
            //Overflow conditions
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && rem > 7)) return 0;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && rem < -8)) return 0;
            
            res = res * 10 + rem;
            x /= 10;
        }
        
        return res;
    }
}
