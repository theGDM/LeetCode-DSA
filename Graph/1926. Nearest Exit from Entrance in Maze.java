//Depth First Search
//TC : O(V + E), where V is the number of vertices, and E  is the number of Edges.
//since, V = m * n, where m and n are number of rows and coloumns, of matrix maze.
//Therefore, E = 4 * V, because from each cell, 4 edges are going in up, left, down, right direction.
//Therefore, TC : O(m * n + 4 * m * n) ~ O(m * n)
//and SC : O(m * n), visited matrix
class Solution {
    public class Pair{
        int r;
        int c;
        int dist;
        
        Pair(){};
        
        Pair(int r, int c, int dist){
            r = this.r;
            c = this.c;
            dist = this.dist;
        }
    }
    
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> q = new ArrayDeque<>();
        int stRow = entrance[0];
        int stCol = entrance[1];
        Pair p = new Pair();
        p.r = stRow;
        p.c = stCol;
        p.dist = 0;
        q.add(p);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int minExit = Integer.MAX_VALUE;
        
        while(q.size() > 0){
            Pair rem = q.remove();
            //if alreday visited, then continue
            if(visited[rem.r][rem.c] == true){
                continue;
            }
            
            //mark visited
            visited[rem.r][rem.c] = true;
            
            //actual work : The (rem.r, rem.c) must be not equal to the stRow and stCol, and (rem.r, rem.c) 
            //must be on the boundry, to calculate min distance to exit from given entrance
            if((rem.r != stRow || rem.c != stCol) && 
               (rem.r == 0 || rem.r == maze.length - 1 || rem.c == 0 || rem.c == maze[0].length - 1)){
                minExit = Math.min(minExit, rem.dist);
            }
            
            //add childs in all the 4 direction
            addChilds(rem.r - 1, rem.c, rem.dist + 1, maze, visited, q);
            addChilds(rem.r, rem.c - 1, rem.dist + 1, maze, visited, q);
            addChilds(rem.r + 1, rem.c, rem.dist + 1, maze, visited, q);
            addChilds(rem.r, rem.c + 1, rem.dist + 1, maze, visited, q);
        }
        
        return minExit == Integer.MAX_VALUE ? -1 : minExit;
    }
    
    public void addChilds(int r, int c, int dist, char[][] maze, boolean[][] visited, Queue<Pair> q){
        if(r < 0 || c < 0 || r >= maze.length || c >= maze[0].length){ //out of boundry
            return;
        }else if(maze[r][c] == '+'){ //walls
            return;
        }else if(visited[r][c]){ //already visited cell
            return; 
        }
        
        //otherwise add the child
        Pair p = new Pair();
        p.r = r;
        p.c = c;
        p.dist = dist;
        q.add(p);
    }
}
