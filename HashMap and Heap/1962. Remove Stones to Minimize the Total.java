//TC : O(nlogn + klogn)
//SC : O(N)
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : piles){
            pq.add(num);
        }
        
        while(k-- > 0){
            int curr = pq.remove();
            int remove = curr / 2;
            pq.add(curr - remove);
        }
        
        int ans = 0;
        for(int num : pq){
            ans += num;
        }
        
        return ans;
    }
}
