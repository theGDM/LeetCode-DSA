//same as rotten oranges
class Solution {
    public class Pair{
        int r;
        int c;
        int dist;
        
        Pair(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] ans = new int[mat.length][mat[0].length];
        
        for(int r = 0; r < mat.length; ++r){
            for(int c = 0; c < mat[0].length; ++c){
                if(mat[r][c] == 0){
                    q.add(new Pair(r, c, 0));
                }
            }
        }
        
        while(q.size() > 0){
            Pair rem = q.remove(); //remove
            
            if(visited[rem.r][rem.c] == true){ //mark*
                continue;
            }
            visited[rem.r][rem.c] = true;
            
            ans[rem.r][rem.c] = rem.dist; //work
            
            //add nbrs
            addNbrs(rem.r, rem.c - 1, rem.dist + 1, mat, visited, q);
            addNbrs(rem.r + 1, rem.c, rem.dist + 1, mat, visited, q);
            addNbrs(rem.r, rem.c + 1, rem.dist + 1, mat, visited, q);
            addNbrs(rem.r - 1, rem.c, rem.dist + 1, mat, visited, q);
        }
        
        return ans;
    }
    
    public void addNbrs(int r, int c, int d, int[][] mat, boolean[][] visited, Queue<Pair> q){
        if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] == 0 || visited[r][c] == true){
            return;
        }
        
        q.add(new Pair(r, c, d));
    }
}
