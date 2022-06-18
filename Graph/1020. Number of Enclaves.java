//In this question we are asked to find the no of islands(count of cells) which do not touches the wall, of the matrix!
//in the 1st approach, i set a global variable flag, which tells me whether found island touches walls or not, if it touches i will not 
//include it in the res Arraylist. and finally we will iterate over the list of arraylist and find the ans. 
class Solution {
    boolean flag = false;
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == 1 && visited[r][c] == false){
                    flag = true;
                    ArrayList<String> land = new ArrayList<>();
                    landAreaNotTouchingWall(r, c, grid, visited, land);
                    if(flag == true){
                        ans.add(land);
                    }
                }
            }
        }
        
        int c = 0;
        for(int i = 0; i < ans.size(); ++i){
            c += ans.get(i).size();
        }
        // System.out.println(ans);
        return c;
    }
    
    public void landAreaNotTouchingWall(int r, int c, int[][] grid, boolean[][] visited,ArrayList<String> land){
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            flag = false;
            return; //we got boundary, so this marked land area will not be counted
        }else if(visited[r][c] == true){
            return; //this cell is already marked
        }else if(grid[r][c] == 0){
            return; //water
        } 
        
        //preorder work
        land.add(r + "" + c);
        visited[r][c] = true;
        //faith calls
        landAreaNotTouchingWall(r, c - 1, grid, visited, land); //left
        landAreaNotTouchingWall(r + 1, c, grid, visited, land); //down
        landAreaNotTouchingWall(r, c + 1, grid, visited, land); //right
        landAreaNotTouchingWall(r - 1, c, grid, visited, land); //up
    }
}

//in the 2nd approch, we made a global variable length and flag, flag will find whether current land area touching the wall or not,
//if we get to know that, its touching the wall, then its len, will not be added in count variable.

class Solution {
    boolean flag = false;
    int len = 0;
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == 1 && visited[r][c] == false){
                    len = 0;
                    flag = true;
                    landAreaNotTouchingWall(r, c, grid, visited);
                    if(flag == true){ //the current island is not touching the wall
                        count += len;
                    }
                }
            }
        }
        
        return count;
    }
    
    public void landAreaNotTouchingWall(int r, int c, int[][] grid, boolean[][] visited){
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            flag = false; //we got boundary, so this marked land area will not be counted
            return; 
        }else if(visited[r][c] == true){
            return; //this cell is already marked
        }else if(grid[r][c] == 0){
            return; //water
        } 
        
        //preorder work
        visited[r][c] = true;
        ++len;
        //faith calls
        landAreaNotTouchingWall(r, c - 1, grid, visited); //left
        landAreaNotTouchingWall(r + 1, c, grid, visited); //down
        landAreaNotTouchingWall(r, c + 1, grid, visited); //right
        landAreaNotTouchingWall(r - 1, c, grid, visited); //up
    }
}

//in the 3rd approach we will first mark lands to water, while traversing over the boundry of grid, so we will get rid of the 
//all the land area that touching the boundaries and the we simply again iterate over each cell not belonging to boundary and
//count all the cells of land

class Solution {
    int count = 0;
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        //we will traverse over boundery and remove the continuous land area, tha touching boundaries
        markBoundryLand(grid, visited);
        
        //now traverse again inside the boundary
        for(int r = 1;r <= grid.length - 2; ++r){
            for(int c = 1;c <= grid[0].length - 2; ++c){
                if(grid[r][c] == 1 && visited[r][c] == false){
                    landAreaNotTouchingWall(r, c, grid, visited);
                }
            }
        }
        
        return count;
    }
    
    public void markBoundryLand(int[][] grid, boolean[][] visited){
        int frow = 0, lrow = grid.length - 1;
        int fcol = 0, lcol = grid[0].length - 1;
        
        for(int i = fcol; i <= lcol; ++i){
            markLandAreaTouchingWall(frow, i, grid, visited);
        }
        ++frow;
        
        for(int j = frow; j <= lrow; ++j){
            markLandAreaTouchingWall(j, lcol, grid, visited);
        }
        --lcol;
        
        for(int k = lcol; k >= fcol; --k){
            markLandAreaTouchingWall(lrow, k, grid, visited);
        }
        --lrow;
        
        for(int l = lrow; l >= frow; --l){
            markLandAreaTouchingWall(l, fcol, grid, visited);
        }
        ++fcol;
    }
    
    public void markLandAreaTouchingWall(int r, int c, int[][] grid, boolean[][] visited){
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return; 
        }else if(visited[r][c] == true){
            return; //this cell is already marked
        }else if(grid[r][c] == 0){
            return; //water
        } 
        
        //preorder work
        visited[r][c] = true;
        grid[r][c] = 0;
        //faith calls
        markLandAreaTouchingWall(r, c - 1, grid, visited); //left
        markLandAreaTouchingWall(r + 1, c, grid, visited); //down
        markLandAreaTouchingWall(r, c + 1, grid, visited); //right
        markLandAreaTouchingWall(r - 1, c, grid, visited); //up
    }
    
    public void landAreaNotTouchingWall(int r, int c, int[][] grid, boolean[][] visited){
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return; 
        }else if(visited[r][c] == true){
            return; //this cell is already marked
        }else if(grid[r][c] == 0){
            return; //water
        } 
        
        //preorder work
        visited[r][c] = true;
        ++count;
        //faith calls
        landAreaNotTouchingWall(r, c - 1, grid, visited); //left
        landAreaNotTouchingWall(r + 1, c, grid, visited); //down
        landAreaNotTouchingWall(r, c + 1, grid, visited); //right
        landAreaNotTouchingWall(r - 1, c, grid, visited); //up
    }
}
