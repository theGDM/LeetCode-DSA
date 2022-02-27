// Given an m x n matrix, return all elements of the matrix in spiral order.
// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int frow = 0, lrow = matrix.length - 1;
        int fcol = 0, lcol = matrix[0].length - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        int n = matrix.length * matrix[0].length;
        int c = 0;
        while(true){
            //top wall
            for(int i = fcol; i <= lcol; ++i){
                ans.add(matrix[frow][i]);
                ++c;
                if(c == n) return ans;
            }
            ++frow;
            
            //right wall
            for(int i = frow; i <= lrow; ++i){
                ans.add(matrix[i][lcol]);
                ++c;
                if(c == n) return ans;
            }
            --lcol;
            
            //bottom wall
            for(int i = lcol; i >= fcol; --i){
                ans.add(matrix[lrow][i]);
                ++c;
                if(c == n) return ans;
            }
            --lrow;
            
            //left wall
            for(int i = lrow; i >= frow; --i){
                ans.add(matrix[i][fcol]);
                ++c;
                if(c == n) return ans;
            }
            ++fcol; 
        }
    }
}
