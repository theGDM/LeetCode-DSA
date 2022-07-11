class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        //traverse first coloumn and last coloumn, and make all the connected o's to *
        for(int i = 0; i < m; ++i){
            DFS(i, 0, visited, board);
            DFS(i, n - 1, visited, board);
        }
        
        //traverse first row and last row, and make all the connected o's to *
        for(int j = 0; j < n; ++j){
            DFS(0, j, visited, board);
            DFS(m - 1, j, visited, board);
        }
        
        //Now mark all the O's to X as all the boundry, touching component having O's are marked
        //to *, so only inner connected O's will be marked those not touching boundry..
        //And also keep changing cell with * values to O..
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void DFS(int r, int c, boolean[][] visited, char[][] board){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length){
            return;
        }else if(visited[r][c] == true){
            return;
        }else if(board[r][c] == 'X'){
            return;
        }
        
        visited[r][c] = true;
        board[r][c] = '*';
        
        DFS(r - 1, c, visited, board);
        DFS(r, c - 1, visited, board);
        DFS(r + 1, c, visited, board);
        DFS(r, c + 1, visited, board);
    } 
}
