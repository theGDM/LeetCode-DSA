class Solution {
    //assume length of num1 >= num2
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        if(num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        
        String sum = "";
        int carry = 0;
        int mul = 1;
        
        for(int i = n2.length - 1; i >= 0; --i){
            int m = n2[i] - '0';
            carry = 0;
            String out = "";
            
            for(int j = n1.length - 1; j >= 0; --j){
                int d = n1[j] - '0';
                int res = d * m + carry;
                int rem = res % 10;
                carry = res / 10;
                
                out = rem + out;
            }
            
            if(carry > 0){
                out = carry + out;
            }
            
            
            for(int k = n2.length - 1; k > i; --k){
                out = out + '0';
            }

            sum = addStrings(sum, out);
        }
        
        return sum;
    }
    
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        int c = 0; //initial carry
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0 || c != 0){
            int d1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            
            int rem = (d1 + d2 + c) % 10;
            c = (d1 + d2 + c) / 10;
            
            res.append(rem);
            
            i--;
            j--;
        }
        
        return res.reverse().toString();
    }
}
