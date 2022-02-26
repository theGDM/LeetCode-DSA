// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

// Example 2:
// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

class Solution {
    public void rotate(int[][] matrix) {
        //step 1 -> transpose the matrix
        transpose(matrix);
        //step 2 -> reverse each row of matrix
        for(int i = 0; i < matrix.length; ++i){
            reverse(matrix, i);
        }
    }
    
    public void reverse(int[][] matrix, int currRow){
        int left = 0;
        int right = matrix[0].length - 1;
        while(left < right){
            int temp = matrix[currRow][left];
            matrix[currRow][left] = matrix[currRow][right];
            matrix[currRow][right] = temp;
            ++left; --right;
        }
    }
    
    public void transpose(int[][] matrix){
        for(int i = 0;i < matrix.length; ++i){
            for(int j = 0;j < matrix[0].length; ++j){
                if(i >= j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
