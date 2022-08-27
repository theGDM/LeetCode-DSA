//dynamic programing(catalan number)
//BST0 = 1;
//BST1 = 1;
//BST2 = 2;
//BST3 = f0.f2 + f1.f1 + f2.f0;
//BST4 = f0.f3 + f1.f2 + f2.f1 + f3.f0;
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; ++i){
            int left = 0;
            int right = i - 1;
            
            while(left <= i - 1){
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
        }
        
        return dp[n];
    }
}
