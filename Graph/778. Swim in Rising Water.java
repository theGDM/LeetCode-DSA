class Solution {
    public class Pair implements Comparable<Pair>{
        int r;
        int c;
        int tesf;
        
        Pair(int r, int c, int tesf){
            this.r = r;
            this.c = c;
            this.tesf = tesf;
        }
        
        public int compareTo(Pair o){
            return this.tesf - o.tesf; //smaller time will remove
        }
    }
    
    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length]; 
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
           
            if(visited[rem.r][rem.c] == true){
                continue;
            }
            visited[rem.r][rem.c] = true;
            
            if(rem.r == grid.length - 1 && rem.c == grid[0].length - 1){
                return rem.tesf;
            }
            
            addNbrs(rem.r, rem.c - 1, rem.tesf, grid, visited, pq);
            addNbrs(rem.r + 1, rem.c, rem.tesf, grid, visited, pq);
            addNbrs(rem.r, rem.c + 1, rem.tesf, grid, visited, pq);
            addNbrs(rem.r - 1, rem.c, rem.tesf, grid, visited, pq);
        } 
        
        return -1; 
    }
    
    public void addNbrs(int r, int c, int t, int[][] grid, boolean[][] visited, PriorityQueue<Pair> pq){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] == true){
            return;
        }
        
        int ot = t;
        int nt = grid[r][c];
        pq.add(new Pair(r, c, Math.max(nt, ot)));
    }
}
