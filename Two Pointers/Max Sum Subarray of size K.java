//TC : O(n)
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> Arr,int N){
        if(k > N) return 0;
        
        int left = 0;
        int right = k - 1;
       
        long sum = 0;
        long ans = 0;
        
        for(int i = 0; i < k; ++i){
            sum += Arr.get(i);
        }
        
        while(right < Arr.size()){
            ans = Math.max(ans, sum);
            right++;
            if(right < Arr.size()) sum = sum + Arr.get(right) - Arr.get(left);
            left++;
        }
        
        return ans;
    }
}

//TC : O(n)
class Solution{
    static long maximumSumSubarray(int win, ArrayList<Integer> Arr,int N){
        if(win > N) return 0;
        
        long currSum = 0;
        for(int i = 0; i < win; ++i){
            currSum += Arr.get(i);
        }
        
        long maxSum = currSum;
        for(int i = win; i < N; ++i){
            int inc = Arr.get(i);
            int exc = Arr.get(i - win);
            
            currSum = currSum + inc - exc;
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}
