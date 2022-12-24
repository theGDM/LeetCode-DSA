//naive approach
//SC : O(3 * n)
//TC : O(nlogn)
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);
        
        int count = 0;
        while(count != n - 1){ //(n - 1)th time 
            long rem = pq.remove();
            count++;
            
            while(pq.size() != 0 && pq.peek() == rem) pq.remove(); //remove the duplicates if present
            
            pq.add(rem * 2);
            pq.add(rem * 3);
            pq.add(rem * 5);
        }
        
        return pq.remove().intValue(); //nth time we will get nth ugly number
    }
    
}
