//TC : O(V + E) ~ O(m * n + 4 * m * n) ~ O(m * n)
//SC : O(m * n), visited array
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int r = 0; r < board.length; ++r){
            for(int c = 0; c < board[0].length; ++c){
                if(board[r][c] == word.charAt(0)){
                   boolean res = search(0, r, c, board, visited, word);
                    if(res) return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(int idx, int r, int c, char[][] board, boolean[][] visited, String word){
        if(idx == word.length()) return true; //means all the character of the words are found
        
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length){ //out of boundry
            return false;
        }else if(board[r][c] != word.charAt(idx)){ //different char than word.charAt(idx)
            return false;
        }else if(visited[r][c] == true){ //visited cell
            return false;
        }
        
        visited[r][c] = true; //mark visited
        
        //up call
        boolean ans1 = search(idx + 1, r - 1, c, board, visited, word);
        if(ans1) return true;
        
        //left call
        boolean ans2 = search(idx + 1, r, c - 1, board, visited, word);
        if(ans2) return true;
        
        //right call
        boolean ans3 = search(idx + 1, r + 1, c, board, visited, word);
        if(ans3) return true;
        
        //down call
        boolean ans4 = search(idx + 1, r, c + 1, board, visited, word);
        if(ans4) return true;
        
        visited[r][c] = false; //backtrack
        
        return false;
    }
}
