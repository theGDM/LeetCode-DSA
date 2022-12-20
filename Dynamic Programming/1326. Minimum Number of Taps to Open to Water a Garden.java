//TC : O(n) + O(n * jumps)
//SC : O(n)
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] jumps = new int[n + 1];
        for(int i = 0; i < jumps.length; ++i){
            int l = Math.max(0, i - ranges[i]);
            int r = Math.min(n, i + ranges[i]);
            
            jumps[l] = Math.max(jumps[l], r - l);
        }
        
        //Now this question has turned to jump game II
        //in which you can take jumps[i] maximum jumps from any index i
        //you have to reach end.
        int[] dp = new int[jumps.length + 1];
        Arrays.fill(dp, -1);
        int ans = helperMemo(0, jumps.length - 1, jumps, dp); 
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    //code of jump game II
    public int helperMemo(int idx, int n, int[] jumps, int[] dp){
        if(idx == n){
            return dp[idx] = 0;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            if(idx + jump <= n){
                ans = Math.min(ans, helperMemo(idx + jump, n, jumps, dp)); 
            }
        }
        
        if(ans != Integer.MAX_VALUE){
            return dp[idx] = ans + 1;
        }
        
        return dp[idx] = ans;
    }
}
