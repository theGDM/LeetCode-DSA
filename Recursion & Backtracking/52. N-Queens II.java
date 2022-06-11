class Solution {
    int countWays = 0;
    public int totalNQueens(int n) {
        boolean[][] visited = new boolean[n][n]; //visited array
        solveNQueendHelper(0, n, visited);
        return countWays;
    }
    
    public void solveNQueendHelper(int row, int n, boolean[][] visited){
        if(row == n){ //base case
            ++countWays;
            return;
        }
        
        //coloumn as options
        for(int col = 0; col < n; ++col){
            if(isQueenSafe(row, col, visited) == true){
                visited[row][col] = true;
                solveNQueendHelper(row + 1, n, visited);
                visited[row][col] = false; //backtracking
            }
        }
    }
    
    public boolean isQueenSafe(int row, int col, boolean[][] visited){
        //vertically
        for(int r = row; r >= 0; --r){
            if(visited[r][col] == true){
                return false;
            }
        }
        
        //upward left diagonally
        int r = row, c = col;
        while(r >= 0 && c >= 0){
            if(visited[r][c] == true){
                return false;
            }
            --r;
            --c;
        }
        
        //upward left right diagonally
        r = row; c = col;
        while(r >= 0 && c < visited.length){
            if(visited[r][c] == true){
                return false;
            }
            --r;
            ++c;
        }
        
        return true;
    }
}
