//TC : O(N + max)
//SC : O(N)
class Solution {
    public int videoStitching(int[][] clips, int time) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] clip : clips){
            int start = clip[0];
            int end = clip[1];
            
            min = Math.min(min, start);
            max = Math.max(max, end);
        }
        
        //making the jumps array
        int[] jumps = new int[max + 1];
        for(int[] clip : clips){
            int start = clip[0];
            int end = clip[1];
            
            int jumpLength = end - start;
            if(jumps[start] < jumpLength){
                jumps[start] = jumpLength;
            }
        }
        
        int[] dp = new int[jumps.length + 1];
        Arrays.fill(dp, -1);
        // Return the minimum number of clips needed so that we can cut the clips into segments that cover the
        // entire sporting event [0, time], that is why not from min index to time
        int ans = memo(0, time, jumps, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public int memo(int idx, int dest, int[] jumps, int[] dp){
        if(idx == dest){
            return dp[idx] = 0;
        }
        
        if(dp[idx] != -1) return dp[idx];
        
        int ans = Integer.MAX_VALUE;
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            if(idx + jump <= dest){
                ans = Math.min(ans, memo(idx + jump, dest, jumps, dp));
            }
        }
        
        if(ans != Integer.MAX_VALUE){
            return dp[idx] = ans + 1;
        }
        
        return dp[idx] = ans;
    }
}

//imp test cases
// [[5,7],[1,8],[0,0],[2,3],[4,5],[0,6],[5,10],[7,10]]
// 5

// [[8,10],[17,39],[18,19],[8,16],[13,35],[33,39],[11,19],[18,35]]
// 20
