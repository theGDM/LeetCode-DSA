//TC : (2^n)
class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        return helper(1, 1, n, "copy") + 1; //as we are doing copy task at the very start
    }
    
    public int helper(int screen, int buffer, int dest, String prevOp){
        if(screen == dest) return 0;        
        if(screen > dest) return Integer.MAX_VALUE; //means from that point we can not achieve the target to reach n, 
        //so return infinity
        
        int ans = 0;
        if(prevOp.equals("copy")){ //if earlier copied task is happend than this time, paste only
            int pasteTask = helper(screen + buffer, buffer, dest, "paste");
            ans = pasteTask;
        }else if(prevOp.equals("paste")){ //if paste task is done earlier, so copy and paste can be done this time
            int copyTask = helper(screen, screen, dest, "copy");
            int pasteTask = helper(screen + buffer, buffer, dest, "paste");
            ans = Math.min(copyTask, pasteTask);
        }
        
        if(ans != Integer.MAX_VALUE){
            return ans + 1;
        }
        
        return ans;
    }
}

//TC : O(n * n)
//Applying Memo, but its time complexity poor than that of recursion code
class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int[][] dp = new int[2 * n + 1][2 * n + 1];
        for(int i = 0; i < 2 * n + 1; ++i){
            Arrays.fill(dp[i], -1);
        }
        
        return memo(1, 1, n, dp, "copy") + 1; //as we are doing copy task at the very start
    }
    
    public int memo(int screen, int buffer, int dest, int[][] dp, String prevOp){
        if(screen == dest) return dp[screen][buffer] = 0;        
        if(screen > dest) return dp[screen][buffer] = Integer.MAX_VALUE; //means from that point we can not achieve 
        //the target to reach n, so return infinity
        
        if(dp[screen][buffer] != -1){
            return dp[screen][buffer];
        }
        
        int ans = 0;
        if(prevOp.equals("copy")){ //if earlier copied task is happend than this time, paste only
            int pasteTask = memo(screen + buffer, buffer, dest, dp, "paste");
            ans = pasteTask;
        }else if(prevOp.equals("paste")){ //if paste task is done earlier, so copy and paste can be done this time
            int copyTask = memo(screen, screen, dest, dp, "copy");
            int pasteTask = memo(screen + buffer, buffer, dest, dp, "paste");
            ans = Math.min(copyTask, pasteTask);
        }
        
        if(ans != Integer.MAX_VALUE){
            return dp[screen][buffer] = ans + 1;
        }
        
        return dp[screen][buffer] = ans;
    }
}
