class Solution {
    // we will treat 2d matrix as 1d array
    // So a cell value can be calculated by:
    // cell value = Total col * row + col.
    // To get the row we’ll divide the cell value by the total column:
    // row = cell value / Total col.
    // For columns, we have to take the remainder values when an int is divided by the column value.
    // col = cell value % Total col.
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return false;
    }
}
