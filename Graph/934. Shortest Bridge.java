//DFS + BFS combined 
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
    
    public int shortestBridge(int[][] grid) {
        boolean[][] visited1 = new boolean[grid.length][grid[0].length];
        Queue<Pair> comp = new ArrayDeque<>();
        boolean found = false;
        //we need to get only one component
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == 1){
                    getAnyComponent(r, c, grid, visited1, comp);
                    found = true;
                    break;
                }
            }
            
            if(found == true) break; //just to come out of the outer loop too 
        }
        
        boolean[][] visited2 = new boolean[grid.length][grid[0].length];
        while(comp.size() > 0){
            Pair rem = comp.remove();
            if(visited2[rem.r][rem.c] == true){
                continue;
            }
            
            visited2[rem.r][rem.c] = true;
            if(grid[rem.r][rem.c] == 1){
                return rem.dist - 1;
            }
            
            addNbrs(rem.r, rem.c - 1, rem.dist + 1, visited2, grid, comp);
            addNbrs(rem.r + 1, rem.c, rem.dist + 1, visited2, grid, comp);
            addNbrs(rem.r, rem.c + 1, rem.dist + 1, visited2, grid, comp);
            addNbrs(rem.r - 1, rem.c, rem.dist + 1, visited2, grid, comp); 
        }
        
        return -1;
    }
    
    public void addNbrs(int r, int c, int dist, boolean[][] visited2, int[][] grid, Queue<Pair> q){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited2[r][c] == true || grid[r][c] == 2){
            return;
        }
        
        q.add(new Pair(r, c, dist));
    }
    
    public void getAnyComponent(int r, int c, int[][] grid, boolean[][] visited1, Queue<Pair> comp){
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return; //we got boundary
        }else if(visited1[r][c] == true){
            return; //this cell is already marked
        }else if(grid[r][c] == 0){
            return; //water
        } 
        
        //preorder work
        visited1[r][c] = true;
        comp.add(new Pair(r, c, 0));
        
        //faith calls
        getAnyComponent(r, c - 1, grid, visited1, comp); //left
        getAnyComponent(r + 1, c, grid, visited1, comp); //down
        getAnyComponent(r, c + 1, grid, visited1, comp); //right
        getAnyComponent(r - 1, c, grid, visited1, comp); //up
        grid[r][c] = 2; //pahle component ke saare 1 ko 2 kardo, jisse dikkat na aaye 2nd component ke 1 identify karne me
    }
}
