// Should be constant time and space. Constant time is because the maximum number of times the loop(s) would run is at worst done for some legitimate roman representation of a number within the range [1,3999]. 
// So, the TC is O(MaxNumOfLoopIterations).
class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder res = new StringBuilder();
        
        while(num > 0){
            for(int i = 0; i < values.length; ++i){
                if(num >= values[i]){
                    res.append(strs[i]); 
                    num -= values[i];
                    break;
                }
            }
        }
        
        return res.toString();
    }
}

//2nd way
class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder res = new StringBuilder();
        //num me se tab tak subtract karo jab tak wo values[i] se chotta na ho jayye(ex : 3), yadi condition fail hoti, then go to outer for loop
        for(int i = 0; i < values.length; ++i){
            while(num >= values[i]){
                res.append(strs[i]); 
                num -= values[i];
            }
        }
        
        return res.toString();
    }
}
