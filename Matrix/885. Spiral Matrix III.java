//TC : O(Max(m, n)^2) 
//SC : O(m * n)
class Solution {
    public int[][] spiralMatrixIII(int m, int n, int rStart, int cStart) {
        int[][] dirts = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //right -> down -> left -> up -> right ..
        int[][] res = new int[m * n][2];
        int d = 0, len = 0, j = 0; //move <len> steps in d direction
        //d will have values 0, 1, 2, 3 {0 - right, 1 - down, 2 - left, 3 - up}
        res[j++] = new int[]{rStart, cStart};
        while(j < m * n){
            if(d == 0 || d == 2) len++; //if we are about to move in right or left direction then increase length by 1
            for(int i = 0; i < len; ++i){ //move len steps in d direction
                rStart += dirts[d][0]; //new cell r idx
                cStart += dirts[d][1]; //new cell c idx
                
                if(rStart >= 0 && cStart >= 0 && rStart < m && cStart < n){ //check within boundry
                    res[j++] = new int[]{rStart, cStart};
                }
            }
            d = (d + 1) % 4; //change direction
        }
        
        return res;
    }
}
