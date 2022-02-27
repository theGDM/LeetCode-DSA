// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
// Example 1:
// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]

// Example 2:
// Input: n = 1
// Output: [[1]]

class Solution {
    public int[][] generateMatrix(int n) {
        int frow = 0, lrow = n - 1;
        int fcol = 0, lcol = n - 1;
        int[][] matrix = new int[n][n];
        int c = 0;
        while(true){
            //top wall
            for(int i = fcol; i <= lcol; ++i){
                matrix[frow][i] = ++c;
                if(c == n * n) return matrix;
            }
            ++frow;
            
            //right wall
            for(int i = frow; i <= lrow; ++i){
                matrix[i][lcol] = ++c;
                if(c == n * n) return matrix;
            }
            --lcol;
            
            //bottom wall
            for(int i = lcol; i >= fcol; --i){
                matrix[lrow][i] = ++c;
                if(c == n * n) return matrix;
            }
            --lrow;
            
            //left wall
            for(int i = lrow; i >= frow; --i){
                matrix[i][fcol] = ++c;
                if(c == n * n) return matrix;
            }
            ++fcol; 
        }
    }
}
