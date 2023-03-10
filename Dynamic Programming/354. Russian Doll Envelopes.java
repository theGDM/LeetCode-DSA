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


//TC : O(nlogn);
//first sort on the basis of width, and apply LIS on the height
//for the case of envelops of equal width, we will sort on the basis of height in decreasing order
class Solution {
    public class sortByWidth implements Comparator<int[]>{
        public int compare(int[] first, int[] second){
            if(first[0] != second[0]){
                return first[0] - second[0];
            }else{
                return second[1] - first[1];
            }
        }
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new sortByWidth());
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        
        int maxBoxes = 0;
        ArrayList<Integer> sorted = new ArrayList<>();
        for(int i = 0; i < envelopes.length; ++i){
            int lb = lowerBound(sorted, envelopes[i][1]);
            if(lb == sorted.size()){
                sorted.add(envelopes[i][1]);
                //current element larger than the largest
                //LIS of one more length
            }else{
                sorted.set(lb, envelopes[i][1]);
            }
        }
        
        return sorted.size(); //this sorted array has the same size as LIS
    }
    
    public int lowerBound(ArrayList<Integer> nums, int target){
        int low = 0, high = nums.size() - 1;
        int idx = nums.size();
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums.get(mid) < target){
                low = mid + 1;
            }else{
                high = mid - 1;
                idx = mid;
            }
        } 
        
        return idx;
    }   
}
