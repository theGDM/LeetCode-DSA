//Quite good question,
// 28 = 1 + 2 + 4 + 7 + 14
//2 -> will help in finding the 14 = 28 / 2
//4 -> will help in finding the 7 = 28 / 4
//so we will run the loop sqrt(num);
//TC : O(n^1/2)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        
        int sum = 1;
        for(int i = 2; i <= Math.sqrt(num); ++i){
            if(num % i == 0){
                sum += i + num / i;
            } 
        }
        
        return num == sum;
    }
}
