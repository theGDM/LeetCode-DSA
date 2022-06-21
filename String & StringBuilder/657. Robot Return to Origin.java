//simple question
class Solution {
    public boolean judgeCircle(String moves) {
        return helper(0, 0, 0, moves);
    }
    
    public boolean helper(int sr, int sc, int idx, String moves){
        if(idx == moves.length()){
            if(sr == 0 && sc == 0){
                return true;
            }else{
                return false;
            }
        }
        
        if(moves.charAt(idx) == 'L'){
            return helper(sr, sc - 1, idx + 1, moves);
        }else if(moves.charAt(idx) == 'D'){
            return helper(sr + 1, sc, idx + 1, moves);
        }else if(moves.charAt(idx) == 'R'){
            return helper(sr, sc + 1, idx + 1, moves);
        }else if(moves.charAt(idx) == 'U'){
            return helper(sr - 1, sc, idx + 1, moves);
        }
        
        //if not any of the command
        return false; //dummy return
    }
}
