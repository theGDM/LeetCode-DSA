//competitive subsequence = lexicographically minimum subsequesce after removeing of of size k, or after removeing //n - k elements
//TC : O(n)
//SC : O(n)
//No problem of leading 0's
//It is similar to remove k digits
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int removal = nums.length - k;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < nums.length; ++i){ //case -1
            int num = nums[i];
            
            while(dq.size() > 0 && removal > 0 && dq.getLast() > num){
                dq.removeLast();
                removal--;
            }
            
            dq.addLast(num);
        }
        
        while(dq.size() > 0 && removal > 0){ //remove last k characters, after processing the whole nums array
            dq.removeLast();           //while k not become 0 and dq.size > 0(case - 2) 
            removal--;
        } 
        
        int[] res = new int[dq.size()];
        int idx = 0;
        
        while(dq.size() > 0){
            res[idx++] = dq.removeFirst();
        }
        
        return res;
    }
}
