//let three consecutive num be x - 1, x, x + 1
//when we add them that must equal to num
// x - 1 + x + x + 1 = 3x = num => x = num / 3
class Solution {
    //TC : O(1) , SC : O(1)
    public long[] sumOfThree(long num) {
    
        if(num % 3 != 0){
            return new long[]{};
        }
        
        return new long[]{num / 3 - 1, num / 3, num / 3 + 1};
    }
}
