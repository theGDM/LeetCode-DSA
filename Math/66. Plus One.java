class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; --i){
            int val = digits[i];
            if(i == digits.length - 1){
                digits[i] = (val + 1) % 10;
                carry = (val + 1) / 10;
                continue;
            }
           
            digits[i] = (val + carry) % 10;
            carry = (val + carry) / 10;
        }
        
        if(carry != 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for(int i = digits.length - 1; i >= 0; --i){
                newDigits[i + 1] = digits[i];
            }
            
            return newDigits;
        }
        return digits;
    }
}

//alternative(smart approach)
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; --i){
            int val = digits[i];
            if(i == digits.length - 1){
                digits[i] = (val + 1) % 10;
                carry = (val + 1) / 10;
                continue;
            }
           
            digits[i] = (val + carry) % 10;
            carry = (val + carry) / 10;
        }
        
        if(carry != 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
}

