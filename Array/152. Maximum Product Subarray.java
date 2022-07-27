//ander wala part answer nahi ho sakta
//0s per tod lo
//max product ya to prefix se aayega, ya to suffix se

class Solution {
    public int maxProduct(int[] nums) {
        int prod = 1;
        int maxProd = Integer.MIN_VALUE;
        
        //max product from preffix
        for(int i = 0; i < nums.length; ++i){
            prod *= nums[i];
            maxProd = Math.max(maxProd, prod);
            
            if(prod == 0){
                prod = 1;
            }
        }
        
        //max product from suffix
        prod = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            prod *= nums[i];
            maxProd = Math.max(maxProd, prod);
            
            if(prod == 0){
                prod = 1;
            }
        }
        
        return maxProd;
    }
}
