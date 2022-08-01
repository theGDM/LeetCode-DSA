//O(n / 2) solution
class Solution {
    public int minOperations(int n) {
        int ans = 0;
        if(n % 2 == 1){
            int idx =  n / 2;
            int num = 2 * idx + 1;
            
            for(int i = 0; i < idx; ++i){
                ans += num - (2 * i + 1);
            }
        }else{
            int idx =  n / 2 - 1;
            int num = 2 * idx + 1;
            num = num + 1; //1 operation, to make center elements equal
            for(int i = 0; i < idx; ++i){
                ans += num - (2 * i + 1);
            }
            
            ans += 1; //additional one step
        } 
        
        return ans;
    }
}

//O(1) solution
class Solution {
    public int minOperations(int n) {
        int k = n / 2;
        if(n % 2 == 1){ // res is equal to sum of first n / 2 even numbers
            return k * (k + 1);
        }else{ //res is equal to first n / 2 odd numbers
            return k * k;
        }
    }
}
