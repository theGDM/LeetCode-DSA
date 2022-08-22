/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
//same as number of train station
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int i = 0;
        for(Interval intv : intervals){
            start[i] = intv.start;
            end[i] = intv.end;
            i++;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        
        i = 0;
        int j = 0;
        int reqd = 0;
        int count = 0;

        while(i < start.length && j < end.length){
            if(start[i] < end[j]){
                i++;
                count++;
            }else{
                j++;
                count--;
            }
        
            reqd = Math.max(reqd, count);
        }

        return reqd;
    }
}
