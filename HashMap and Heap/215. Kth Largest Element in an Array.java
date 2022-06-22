//by using priority queue
//TC : nlog(k)
//We will simply make an pq of size k,  which will hold the best k numbers
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; ++i){
            if(i < k){
                pq.add(nums[i]); //log(k)
            }else{
                if(pq.peek() < nums[i]){
                    pq.remove(); //log(k)
                    pq.add(nums[i]); //log(k)
                }
            }
        }
        
        return pq.peek(); //O(1)
    }
}
