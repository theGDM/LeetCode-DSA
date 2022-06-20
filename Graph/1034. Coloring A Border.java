//TC : O(E + V) = O(m * n + 4 * n * m)
//SC : O(n * m)
//DFS Traversal(Preorder me kaam)
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] ans = new int[grid.length][grid[0].length];
        
        int rc = grid[row][col];
        makeBoundry(row, col, rc, grid, visited, color, ans);
        
        //now fill the ans matrix with the cell value which were not visited in the grid matrix
        for(int i = 0;i < grid.length; ++i){
            for(int j = 0;j < grid[0].length; ++j){
                if(visited[i][j] == false){
                    ans[i][j] = grid[i][j];
                }
            }
        }
        
        return ans;
    }
    
    public void makeBoundry(int r, int c, int rc, int[][] grid, boolean[][] visited, int color, int[][] ans){
        //base conditions
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }else if(visited[r][c] == true){
            return;
        }else if(grid[r][c] != rc){
            return;
        }
        
        //preorder visit mark
        visited[r][c] = true;
        
        //work in preorder
        if(checkIfBoundry(r, c, rc, grid)){
            ans[r][c] = color;
        }else{
            ans[r][c] = grid[r][c];
        }
        
        makeBoundry(r, c - 1, rc, grid, visited, color, ans); //left
        makeBoundry(r + 1, c, rc, grid, visited, color, ans); //down
        makeBoundry(r, c + 1, rc, grid, visited, color, ans); //right
        makeBoundry(r - 1, c, rc, grid, visited, color, ans); //up
    }
    
    //code to check for boundry
    public boolean checkIfBoundry(int r, int c, int rc, int[][] grid){
        if(r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1){
            return true;
        }else if(grid[r - 1][c] != rc){
            return true;
        }else if(grid[r][c - 1] != rc){
            return true;
        }else if(grid[r + 1][c] != rc){
            return true;
        }else if(grid[r][c + 1] != rc){
            return true;
        }else{
            return false;
        }
    }
}



//TC : O(E + V) = O(m * n + 4 * n * m)
//SC : O(n * m)
//DFS Traversal
//yadi shortest path vagerah puchte hai to BFS should be used, otherwise just to travle, we can use any of the
//traversal eithe BFS or DFS
//iss solution me ham preorder me jaate hue jo original color hai usko -oc se mark karte jaayenge aur lautte samay
//i.e postorder(jab kisi cell ki charo call lag jati hai) me check karenge ki kya yah color charo aur se -oc ke absoulte
//se surrounded hai ya nahi, yadi hai to is grid ki value ko +ve value se replace kar denge
//aur finally jab ham poora traverse kar lenge to kebal bahi cells boundry hai jinki -ve value hai
class Solution {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int oc = grid[row][col];
        traverseDFS(row, col, oc, grid);
        
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == -oc){
                    grid[r][c] = color;
                }
            }
        }
        
        return grid;
    }
    
    public void traverseDFS(int r, int c, int oc, int[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }else if(grid[r][c] != oc){
            return;
        }
        
        //preorder me jo cells oc ki hai unko -oc se mark kar diya
        grid[r][c] = -oc;
        
        traverseDFS(r, c - 1, oc, grid);
        traverseDFS(r + 1, c, oc, grid);
        traverseDFS(r, c + 1, oc, grid);
        traverseDFS(r - 1, c, oc, grid);
        
        //post order me check karenge ki yadi oc wali cells not a border hai ki nahi
        if(r > 0 && c > 0 && r < grid.length - 1 && c < grid[0].length - 1
          && Math.abs(grid[r][c - 1]) == oc
          && Math.abs(grid[r + 1][c]) == oc
          && Math.abs(grid[r][c + 1]) == oc
          && Math.abs(grid[r - 1][c]) == oc){
            grid[r][c] = oc;
        }
    }
}
    


//BFS Traversal
//TC : O(E + V) = O(m * n + 4 * n * m)
//SC : O(n * m)
//yadi shortest path vagerah puchte hai to BFS should be used, otherwise just to travle, we can use any of the
//traversal eithe BFS or DFS
class Solution {
    public class Pair{
        int r;
        int c;
        boolean border;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int rc = grid[row][col]; //getting the received color
        
        ArrayList<Pair> res = new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<>();
        Pair p = new Pair(row, col);
        p.border = checkIfBorder(row, col, rc, grid); //ye pair apne ander pair property ko set kar raha bus, yadi 
        q.add(p);                                     //boundry hai to true otherwise false. chahe border true hai ya 
                                                      //ya false q me to ja hi raha hai
        while(q.size() > 0){
            Pair rem = q.remove();
            if(visited[rem.r][rem.c] == true){
                continue;
            }
            
            visited[rem.r][rem.c] = true;
            
            //one optimization yadi border hai to hi add karein
            if(rem.border == true){
                res.add(rem);
            }
            
            addNbrs(rem.r - 1, rem.c, rc, grid, visited, q);
            addNbrs(rem.r, rem.c - 1, rc, grid, visited, q);
            addNbrs(rem.r + 1, rem.c, rc, grid, visited, q);
            addNbrs(rem.r, rem.c + 1, rc, grid, visited, q);
        }
        
        //now fill the boundry with the color given to us
        for(Pair pair : res){
            grid[pair.r][pair.c] = color;
        }
        
        return grid;
    }
    
    public void addNbrs(int r, int c, int rc, int[][] grid, boolean[][] visited, Queue<Pair> q){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] == true || grid[r][c] != rc){
            return;
        }
        
        
        Pair p = new Pair(r, c);
        p.border = checkIfBorder(r, c, rc, grid);
        q.add(p);
    }
    
    //code to check for boundry
    public boolean checkIfBorder(int r, int c, int rc, int[][] grid){
        if(r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1){
            return true;
        }else if(grid[r - 1][c] != rc){
            return true;
        }else if(grid[r][c - 1] != rc){
            return true;
        }else if(grid[r + 1][c] != rc){
            return true;
        }else if(grid[r][c + 1] != rc){
            return true;
        }else{
            return false;
        }
    }
}
