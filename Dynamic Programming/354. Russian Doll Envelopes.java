//TC : O(n2);
//first sort on the basis of width, and apply LIS on the height
//for the case of envelops of equal width, we will sort on the basis of height in decreasing order
class Solution {
    public class sortByWidth implements Comparator<int[]>{
        public int compare(int[] first, int[] second){
            if(first[0] != second[0]){
                return first[0] - second[0];
            }else{
                return first[1] - second[1];
            }
        }
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new sortByWidth());
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        
        int maxBoxes = 0;
        for(int i = 1; i < envelopes.length; ++i){ 
            for(int j = 0; j < i; ++j){
                if(envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
           
            maxBoxes = Math.max(maxBoxes, dp[i]);
        }
    
        return maxBoxes;
    }
}

