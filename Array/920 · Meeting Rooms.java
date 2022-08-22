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
//TC : O(nlog(n))
//SC : O(n);
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */

    public class Pair implements Comparable<Pair>{
        int start;
        int end;

        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair o){
            return this.start - o.start;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if(intervals.size() == 0) return true;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Interval p : intervals){
            pq.add(new Pair(p.start, p.end));
        }

        int currEnd = pq.remove().end;
        while(pq.size() > 0){
            Pair rem = pq.remove();
            if(rem.start < currEnd){
                return false;
            }else{
                currEnd = rem.end;
            }
        }

        return true;
    }
}


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
//Using comparator
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */

    // Helper class implementing Comparator interface
    public static class sortByStart implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if(intervals.size() == 0 || intervals == null) return true;
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(new sortByStart());
        for(Interval p : intervals){
            pq.add(p);
        }

        int currEnd = pq.remove().end;
        while(pq.size() > 0){ 
            Interval rem = pq.remove();
            if(rem.start < currEnd){
                return false;
            }else{
                currEnd = rem.end;
            }
        }

        return true;
    }
}


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
//TC : nlog(n)
//SC : O(n)
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if(intervals.size() == 0 || intervals == null) return true;

        //nlog(n)
        Collections.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });

        for(int i = 0; i < intervals.size() - 1; i++){
            if(intervals.get(i).end > intervals.get(i + 1).start){
                return false;
            }
        }

        return true;
    }
}


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
//TC : O(2n)
//SC : O(2n)
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if(intervals.size() == 0 || intervals == null) return true;

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

        return reqd == 1;
    }
}
