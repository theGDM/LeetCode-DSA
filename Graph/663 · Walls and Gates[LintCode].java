public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */

    //similar to, land as far as possible
    //BFS
    //TC : O(v + e) = O(m * n + 4 * m * n) ~ O(m * n)
    //SC : O(m * n)
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

    public void wallsAndGates(int[][] rooms) {
        // write your code here
        int m = rooms.length;
        int n = rooms[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new ArrayDeque<>();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(rooms[r][c] == 0){ //add all the gates in the queue
                    q.add(new Pair(r, c, 0));
                }
            }
        }

        while(q.size() > 0){
            Pair rp = q.remove();

            if(visited[rp.r][rp.c] == true){
                continue;
            }

            visited[rp.r][rp.c] = true;

            if(rooms[rp.r][rp.c] == Integer.MAX_VALUE){ //work
                rooms[rp.r][rp.c] = rp.dist;
            }

            addNbrs(rp.r - 1, rp.c, rp.dist + 1, visited, rooms, q);
            addNbrs(rp.r, rp.c - 1, rp.dist + 1, visited, rooms, q);
            addNbrs(rp.r + 1, rp.c, rp.dist + 1, visited, rooms, q);
            addNbrs(rp.r, rp.c + 1, rp.dist + 1, visited, rooms, q);
        }
    }

    public void addNbrs(int r, int c, int dist, boolean[][] visited, int[][] rooms, Queue<Pair> q){
        if(r >= 0 && c >= 0 && r < rooms.length && c < rooms[0].length && visited[r][c] == false && rooms[r][c] == Integer.MAX_VALUE){
            q.add(new Pair(r, c, dist));
        }
    }
}
