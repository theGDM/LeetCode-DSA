//TC : O(M * N)
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        
        //checking lower triangle
        int r = m;
        while(r > 0){
            int checkValue = matrix[r][0];
            int i = r + 1, j = 1;
            while(i <= m && j <= n){
                if(matrix[i][j] != checkValue){
                    return false;
                }
                i++; j++;
            }
            r--;
        }
        
        //checking upper triangle
        int c = 0;
        while(c <= n){
            int checkValue = matrix[0][c];
            int i = 1, j = c + 1;
            while(i <= m && j <= n){
                if(matrix[i][j] != checkValue){
                    return false;
                }
                i++; j++;
            }
            c++;
        }
        
        return true;
    }
}
