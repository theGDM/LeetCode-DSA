// A[i][j] on the same diagonal have same value of i - j
// For each diagonal,
// put its elements together, sort, and set them back.

// Time O(MNlogD), where D is the length of diagonal with D = min(M,N).
// Space O(MN)
// since size of priority queue can be at max, diagonal length
// total diagonal = m + n - 1
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int gap = i - j;
                
                if(hm.containsKey(gap) == false){
                    hm.put(gap, new PriorityQueue<>());
                    hm.get(gap).add(mat[i][j]);
                }else{
                    hm.get(gap).add(mat[i][j]);
                }
            }
        }
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int gap = i - j;
                mat[i][j] = hm.get(gap).remove();
            }
        }
        
        return mat;
    }
}
