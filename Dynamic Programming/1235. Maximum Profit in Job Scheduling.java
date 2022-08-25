//TC : O(n2)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        
        for(int i = 0; i < jobs.length; ++i){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        Arrays.sort(jobs, (j1, j2) -> {
            if(j1[0] != j2[0]){
                return j1[0] - j2[0]; //first sort on the basis of start time
            }else{
                return j2[1] - j1[1]; //if start time are equal, then sort on the basis of end time, in decreasing order
            }
        });
        
        int[] LIS = new int[jobs.length];
        LIS[0] = jobs[0][2];
        
        for(int i = 1; i < jobs.length; ++i){
            int max = 0;
            for(int j = 0; j < i; ++j){
                if(jobs[j][1] <= jobs[i][0]){ //pichli jobs ka finish time <= curr job ka start time
                    max = Math.max(max, LIS[j]);
                } 
            }
            
            LIS[i] = max + jobs[i][2];
        }
        
        int maxProfit = 0;
        for(int p : LIS){
            maxProfit = Math.max(maxProfit, p);
        }
        
        return maxProfit;
    }
}
