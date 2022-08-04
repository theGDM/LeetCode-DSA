//User function Template for Java
//we are starting dividing from 9, because jitna bade number se divide hoga, utna chhota 
//number banga

//TC : O(log(N))
//let say saare division 2 se hue hai, tilll number becomes
//Therefore TC : O(log(N))

class Solution {
    static String getSmallest(Long N) {
        // code here
        if(N <= 9) return N + "";
        StringBuilder res = new StringBuilder();
        for(int i = 9; i >= 2; --i){
            while(N % i == 0){ //iss number ko tab tak kaatege, jb tak us number se kat raha hai
                res.append(i);
                N /= i;
            }
        }
        
        if(N != 1) return "-1"; //means given number can't be divide fully
        return res.reverse().toString();
    }
};
