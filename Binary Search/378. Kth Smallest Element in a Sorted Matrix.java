//TC : NLOG(N) ~ n2log(n2); ~ 2n^2log(n);
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int size = matrix.length * matrix[0].length;
        if(k > size) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                pq.add(matrix[i][j]);
            }
        }
        
        int n = size - k;
        while(n-- > 0){
            pq.remove();
        }
        
        return pq.peek();
    }
}

