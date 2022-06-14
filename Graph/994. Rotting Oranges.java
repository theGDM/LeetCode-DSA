class Solution {
    int freshCount = 0;
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        Queue<Pair> q = new ArrayDeque<>();
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == 2){
                    q.add(new Pair(r, c, 0)); //add all the rotten oranges in the queue
                }else{
                    ++freshCount; //count fresh oranges
                }
            }
        }
        
        infectOranges(grid, visited, q);
        
        if(freshCount == 0){
            return time;
        }else{
           return -1;  
        } 
    }
    
    public class Pair{
        int r;
        int c;
        int rt;
        
        Pair(int r, int c, int rt){
            this.r = r; //current row
            this.c = c; //current col
            this.rt = rt; //rottening time
        }
    }
    
    int time = 0;
    public void infectOranges(int[][] grid, boolean[][] visited, Queue<Pair> q){
        while(q.size() > 0){
            Pair rp = q.remove(); //remove
            
            if(visited[rp.r][rp.c] == true){ //mark*
                continue;
            }
            
            visited[rp.r][rp.c] = true; 
            
            //work
            if(rp.rt > time){
                time = rp.rt;
            }
            
            if(grid[rp.r][rp.c] == 1){
                --freshCount; //decrease the count of the fresh oranges by one
            }
            
            //add nbrs
            addNbrs(rp.r, rp.c - 1, rp.rt + 1, visited, grid, q);
            addNbrs(rp.r + 1, rp.c, rp.rt + 1, visited, grid, q);
            addNbrs(rp.r, rp.c + 1, rp.rt + 1, visited, grid, q);
            addNbrs(rp.r - 1, rp.c, rp.rt + 1, visited, grid, q); 
        }
    }
    
    public void addNbrs(int r, int c, int rt, boolean[][] visited, int[][] grid, Queue<Pair> q){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] == true || grid[r][c] == 0){
            return;
        }
        
        q.add(new Pair(r, c, rt));
    }
}

//wrong way, if we do it by get connected components(Test case : 132)
class Solution {
    int freshCount = 0;
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        countFreshOranges(grid);
        if(freshCount == 0) return 0;
        
        Queue<Pair> q = new ArrayDeque<>();
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == 2){
                    infectOranges(r, c, grid, visited); //add all the rotten oranges in the queue
                }
            }
        }
        
        if(freshCount == 0){
            return time;
        }else{
           return -1;  
        } 
    }
    
    public void countFreshOranges(int[][] grid){
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == 1){
                    ++freshCount;
                }
            }
        }
    }
    
    public class Pair{
        int r;
        int c;
        int rt;
        
        Pair(int r, int c, int rt){
            this.r = r; //current row
            this.c = c; //current col
            this.rt = rt; //rottening time
        }
    }
    
    int time = 0;
    public void infectOranges(int r, int c, int[][] grid, boolean[][] visited){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(r, c, 0));
        
        while(q.size() > 0){
            Pair rp = q.remove(); //remove
            
            if(visited[rp.r][rp.c] == true){ //mark*
                continue;
            }
            
            visited[rp.r][rp.c] = true; 
            
            //work
            if(rp.rt > time){
                time = rp.rt;
            }
            
            if(grid[rp.r][rp.c] == 1){
                --freshCount; //decrease the count of the fresh oranges by one
            }
            
            //add nbrs
            addNbrs(rp.r, rp.c - 1, rp.rt + 1, visited, grid, q);
            addNbrs(rp.r + 1, rp.c, rp.rt + 1, visited, grid, q);
            addNbrs(rp.r, rp.c + 1, rp.rt + 1, visited, grid, q);
            addNbrs(rp.r - 1, rp.c, rp.rt + 1, visited, grid, q); 
        }
    }
    
    public void addNbrs(int r, int c, int rt, boolean[][] visited, int[][] grid, Queue<Pair> q){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] == true || grid[r][c] == 0){
            return;
        }
        
        q.add(new Pair(r, c, rt));
    }
}
