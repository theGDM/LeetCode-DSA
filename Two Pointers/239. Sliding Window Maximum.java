//1. Here we introduce an interesting data structure. It's a deque with an interesting property - the 
// elements in the deque from head to tail are in decreasing order (hence the name monotonic).
//2. To achieve this property, we modify the push operation so that
// Before we push an element into the deque, we first pop everything smaller than it out of the deque.
// This enforces the decreasing order.
//3. The time complexity is O(N). This is because each element in the original array can only be pushed 
//into and popped out of the deque only once.
//4 The key why monotonic deque works is it stores both magnitude and position information. From head to
//tail, the elements get smaller and further to the right of the array.

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        
        for(int i = 0; i < nums.length; ++i){      
            // remove first element if it's outside the window
            if(dq.size() > 0 && dq.getFirst() == i - k){
                dq.removeFirst();
            }
            
            while(dq.size() > 0 && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }
            //we could be the possible answer of the someone, so add yourself
            dq.addLast(i);
            
            //if window has k elements add to results (first k-1 windows have < k elements because we
            //start from empty window and add 1 element each iteration)
            if(i >= k - 1){
                res[idx++] = nums[dq.getFirst()];
            }
        }
        
        return res;
    }
}
