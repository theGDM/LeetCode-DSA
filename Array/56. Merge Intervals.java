//TC : O(nlog(n)) + O(intervals.length)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> { //O(nlogn)
            return a[0] - b[0]; //sort on the basis of 0th index of interval
        });
        
        ArrayList<int[]> res = new ArrayList<>();
        
        for(int[] interval : intervals){
            if(res.size() == 0){
                res.add(interval); //if res size is 0, then just add the interval
            }else{
                int[] last = res.get(res.size() - 1);
                if(last[1] >= interval[0]){
                    last[1] = Math.max(last[1], interval[1]); //merged ([1, 6] and [2, 3]) ~ [1, 6]
                }else{
                    res.add(interval); //not mergable, so add interval
                }
            }
        }
        
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); ++i){
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}
