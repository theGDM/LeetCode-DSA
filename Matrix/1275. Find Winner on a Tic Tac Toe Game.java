//At worst the size of moves matrix can be, n * n
//so for each move, we are doing work of 4 * n at worst
//so worst time complexity will be : TC : O(4 * n^3);
//SC : O(n^2)

class Solution {
    int n = 3;
    public String tictactoe(int[][] moves) {
        char[][] board = new char[n][n];
        
        for(int i = 0; i < moves.length; ++i){
            int r = moves[i][0];
            int c = moves[i][1];
            
            if(i % 2 == 0){ //A's turn, so he will mark with 'X'
                board[r][c] = 'X';
                if(didPlayerWin(board, r, c, 'X')) return "A";
            }else{ //B's turn, so he will mark with 'O'
                board[r][c] = 'O';
                if(didPlayerWin(board, r, c, 'O')) return "B";
            }
        }
        
        return moves.length == n * n ? "Draw" : "Pending";
    }
    
    public boolean didPlayerWin(char[][] board, int r, int c, char player){
        boolean playerWon = true;
        
        //checking in the whole row
        for(int i = 0; i < n; ++i){
            if(board[i][c] != player){
                playerWon = false;
                break;
            }
        }
        if(playerWon) return true;
    
        //checking the whole coloumn
        playerWon = true;
        for(int j = 0; j < n; ++j){
            if(board[r][j] != player){
                playerWon = false;
                break;
            }
        }
        if(playerWon) return true;
        
        //checking the coloumn
        if(r == c){
            playerWon = true;
            for(int di = 0; di < n; ++di){
                if(board[di][di] != player){
                    playerWon = false;
                    break;
                }
            }
            if(playerWon) return true;
        }
        
        //checking the reverse coloumn
        if(c == n - r - 1){
            playerWon = true;
            for(int rdi = 0; rdi < n; ++rdi){
                if(board[rdi][n - rdi - 1] != player){
                    playerWon = false;
                    break;
                }
            }
            if(playerWon) return true;
        }
        
        return false;
    }
}
