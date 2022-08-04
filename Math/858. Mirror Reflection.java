class Solution {
    public int mirrorReflection(int p, int q) {
        while(q % 2 == 0 && p % 2 == 0){ //reduce to minimal
            q /= 2;
            p /= 2;
        }
        
        //if p is odd and q is even, then light will get absorb at recepetor 0.(ex: p = 3, q = 2)
        if(p % 2 == 1 && q % 2 == 0){
            return 0;
        }
        
        //if q is odd and p is odd, then light will get absorb at recepetor 1.(ex: p = 1, q = 1)
        if(p % 2 == 1 && q % 2 == 1){
            return 1;
        }
        
        //if q is odd and p is even, then light will get absorb at recepetor 2.(ex: p = 2, q = 1)
        if(p % 2 == 0 && q % 2 == 1){
            return 2;
        }
        
        return -1;
    }
}
