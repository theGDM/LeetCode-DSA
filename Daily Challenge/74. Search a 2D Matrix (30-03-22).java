//binary search on each rows
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        for(int i = 0;i < matrix.length; ++i){
            found = binarySearchOnRows(matrix, i, target);
            if(found != false){
                return found;
            }
        }
        return false;
    }
    
    public boolean binarySearchOnRows(int[][] matrix, int currRow, int target){
        int left = 0;
        int right = matrix[0].length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[currRow][mid] < target){
                left = mid + 1;
            }else if(matrix[currRow][mid] > target){
                right = mid - 1;
            }else{
                return true;
            }
        }
        
        return false;
    }
}
