//TC : O(n^2 + n^2 + n^2) ~ O(n^2).
//SC : O(9) ~ O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //checking the row
        HashMap<Character, Integer> map;
        for(int col = 0; col < board[0].length; ++col){
            map = new HashMap<>(); //update map
            for(int row = 0; row < board.length; ++row){
                char num = board[row][col];
                if(map.containsKey(num)) return false;
                else if(num != '.') map.put(num, 1);
            }
        }
        
        //checking the col
        for(int row = 0; row < board.length; ++row){
            map = new HashMap<>(); //update map
            for(int col = 0; col < board.length; ++col){
                char num = board[row][col];
                if(map.containsKey(num)) return false;
                else if(num != '.') map.put(num, 1);
            }
        }
        
        //checking each boxes
        int row = 0, col = 0;
        while(col < board[0].length){
            row = 0;
            while(row < board.length){
                map = new HashMap<>(); //update map for maping new box values
                for(int r = row; r < row + 3; ++r){
                    for(int c = col; c < col + 3; ++c){
                        // System.out.print("(" + r + ", " + c + ")");
                        char num = board[r][c];
                        if(map.containsKey(num)) return false;
                        else if(num != '.') map.put(num, 1);
                    }
                }
                row = row + 3;
            }
            col = col + 3;
        }
        
        return true;
    }
}

//TC : O(n2)
//SC : O(9 * 9) ~ O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if(num == '.') continue;
                
                if(set.contains(num + " in row " + row) == false){
                    set.add(num + " in row " + row);
                }else{
                    return false;
                }
                
                if(set.contains(num + " in col " + col) == false){
                    set.add(num + " in col " + col);
                }else{
                    return false;
                }
                
                if(set.contains(num + " in block " + (row / 3)  + "," + (col / 3)) == false){
                    set.add(num + " in block " + (row / 3)  + "," + (col / 3));
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}

