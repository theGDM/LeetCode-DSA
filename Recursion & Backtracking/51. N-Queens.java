class Solution {

    public List<List<String>> solveNQueens(int n) {
        boolean[][] visited = new boolean[n][n]; //visited array
        List<List<String>> res = new ArrayList<>(); //resultant list
        List<String> way = new ArrayList<>();//one of the way
        solveNQueendHelper(0, n, visited, way, res);
        return res;
    }
    
    public void solveNQueendHelper(int row, int n, boolean[][] visited, List<String> way, List<List<String>> res){
        if(row == n){ //base case
            res.add(new ArrayList(way));
            return;
        }
        
        //coloumn as options
        for(int col = 0; col < n; ++col){
            if(isQueenSafe(row, col, visited) == true){
                visited[row][col] = true;
                sitQueen(col, n, way); //sit
                solveNQueendHelper(row + 1, n, visited, way, res);
                way.remove(way.size() - 1); //unsit
                visited[row][col] = false; //backtracking
            }
        }
    }
    
    public void sitQueen(int col, int n, List<String> way){
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < n; ++j){
            if(j == col){
                sb.append("Q");
            }else{
                sb.append(".");
            }
        }
        
        way.add(sb.toString());
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
