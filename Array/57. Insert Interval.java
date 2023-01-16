class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        
        int i = 0;
        //step 1 -> add all non-overlapping intervals
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        
        //step 2 -> make oevralaping interval
        int[] interval = newInterval;
        while(i < intervals.length && intervals[i][0] <= interval[1]){
            interval[0] = Math.min(interval[0], intervals[i][0]); 
            interval[1] = Math.max(interval[1], intervals[i][1]); 
            i++;
        }
        res.add(newInterval);
        
        //step 3 -> add remaining non overlapping intervals
        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        
        
        return res.toArray(new int[res.size()][2]);
    }
}

//TC : O(N)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        //first step -> adding all the non overlapping intervals
        
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        
        //step 2 -> making the merged Interval
        int min = newInterval[0];
        int max = newInterval[1];
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
            i++;
        }
        
        list.add(new int[]{min, max});
        
        //third step - add remaining intervals
        while(i < intervals.length){
            list.add(intervals[i]);
            i++;
        }
        
        int[][] res = new int[list.size()][2];
        for(i = 0; i < list.size(); ++i){
            res[i] = list.get(i);
        }
        
        return res;
    }
}
