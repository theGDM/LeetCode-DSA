class Solution {
    public long[] nextSmallestElementToRight(int[] arr){
        long[] nser = new long[arr.length];
        Stack<Integer> stk = new Stack<>();
        
        for(int i = arr.length - 1; i >= 0; --i){ //not strictly
            while(stk.size() > 0 && arr[i] < arr[stk.peek()]){
                stk.pop();
            }
            
            if(stk.size() > 0){
                nser[i] = stk.peek();
            }else{
                nser[i] = arr.length;
            }
            stk.push(i);
        }
        
        return nser;
    }
    
    public long[] nextSmallestElementToLeft(int[] arr){ //strictly
        long[] nsel = new long[arr.length];
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < arr.length; ++i){
            while(stk.size() > 0 && arr[i] <= arr[stk.peek()]){
                stk.pop();
            }
            
            if(stk.size() > 0){
                nsel[i] = stk.peek();
            }else{
                nsel[i] = -1;
            }
            stk.push(i);
        }
        
        return nsel;
    }
    
    long MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        long[] nser = nextSmallestElementToRight(arr); //O(n)
        long[] nsel = nextSmallestElementToLeft(arr); //O(n)
        
        long sum = 0;
        for(int i = 0; i < arr.length; ++i){
            sum += arr[i] * ((i - nsel[i]) * (nser[i] - i));
        }
        
        return (int)(sum % MOD);
    }
}
