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
