//as we know, that sum of odd numbers lead to the formation of perfect square number
//1 = 1
//1 + 3 = 4
//1 + 3 + 5 = 9
//1 + 3 + 5 + 7 = 16
//1 + 3 + 5 + 7 + 9 = 25
//O(sqrt(num)) //1ms Solution
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num > 0){
            num -= i;
            i += 2;
            
            if(num == 0) return true;
        }
        
        return false;
    }
}

//TC : O(logn), 100% faster
//Binary search on answer
class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 0;
        long end = num;
        
        while(start < end){
            long mid = end + (start - end) / 2;
     
            if(mid * mid == num){
                return true;
            }else if(mid * mid < num){
                start = mid;
            }else{
                end = mid - 1;
            }
        }
        
        return false;
    }
}
