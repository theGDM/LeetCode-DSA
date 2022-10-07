//Binary search on answer
//TC : O(logn)
class Solution {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        
        while(start < end){
            long mid = end + (start - end) / 2;
     
            if(mid * mid == x){
                return (int)mid;
            }else if(mid * mid < x){
                start = mid;
            }else{
                end = mid - 1;
            }
        }
        
        return (int)start;
    }
}
