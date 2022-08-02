class Solution {
    //starting from top-right corner O(n + m)//at wrost target element found at the bottom-left corner
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row < matrix.length && col >= 0){
            if(target == matrix[row][col]){
                return true;
            }else if(target < matrix[row][col]){
                col--;
            }else if(target > matrix[row][col]){
                row++;
            }
        }
        
        return false;
    }
}

class Solution {
    //starting from bottom-left corner O(n + m)//at wrost target element found at the top-right corner
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        
        int row = matrix.length - 1;
        int col = 0;
        
        while(row >= 0 && col < matrix[0].length){
            if(target == matrix[row][col]){
                return true;
            }else if(target < matrix[row][col]){
                row--;
            }else if(target > matrix[row][col]){
                col++;
            }
        }
        
        return false;
    }
}
