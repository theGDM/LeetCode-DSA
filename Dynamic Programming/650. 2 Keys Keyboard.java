//TC : (2^n)
class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        return helper(1, 1, n, "copy") + 1; //as we are doing copy task at the very start
    }
    
    public int helper(int curr, int buffer, int n, String prevOp){
        if(curr == n) return 0;        
        if(curr > n) return Integer.MAX_VALUE; //means from that point we can not achieve the target to reach n, 
        //so return infinity
        
        int ans = 0;
        if(prevOp.equals("copy")){ //if earlier copied task is happend than this time, paste only
            int pasteTask = helper(curr + buffer, buffer, n, "paste");
            ans = pasteTask;
        }else if(prevOp.equals("paste")){ //if paste task is done earlier, so copy and paste can be done this time
            int copyTask = helper(curr, curr, n, "copy");
            int pasteTask = helper(curr + buffer, buffer, n, "paste");
            ans = Math.min(copyTask, pasteTask);
        }
        
        if(ans != Integer.MAX_VALUE){
            return ans + 1;
        }
        
        return ans;
    }
}
