//first approach
class Solution {
    public int addDigits(int num) {
        int sum = 0;
        int temp = num;
        while(temp != 0){
            int r = temp % 10;
            sum += r;
            temp /= 10;
            if(temp == 0){
                if((int) Math.floor(Math.log10(sum)) + 1 == 1){
                    return sum;
                }
                
                temp = sum;
                sum = 0;
            }
        }
        
        return sum;
    }
}

//2nd approach TC : O(1)
class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }
}
