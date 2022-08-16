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


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[m - 1][n - 1];
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            int actualSmallerThanMid = 0;
            int j = n - 1;
            for(int i = 0; i < m; ++i){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                
                actualSmallerThanMid += (j + 1);
            }
            
            if(actualSmallerThanMid < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
}
