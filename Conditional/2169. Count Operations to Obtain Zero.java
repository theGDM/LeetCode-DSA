class Solution {
    public int countOperations(int num1, int num2) {
        int steps = 0;
        // while(num1 > 0 && num2 > 0){
        //     if(num1 >= num2){
        //         num1 -= num2;
        //     }else{
        //         num2 -= num1;
        //     }
        //     ++steps;
        // }
        // return steps;
        
        while(num1 > 0 && num2 > 0){
            if(num1 >= num2){
                steps += num1 / num2;
                num1 %= num2; 
            }else{
                steps += num2 / num1;
                num2 %= num1; 
            }
        }
        return steps;
    }
}
