//1st approach - here we have given graph matrix, in which every cell represents a node, and 4 direction fron that cell are its edges
//So here, we will also get path of that island, so which will differentiate it from the others. If there are same island we will count them as one.

public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayList<String> path = new ArrayList<>();
        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == 1 && visited[r][c] == false){
                    StringBuilder psf = new StringBuilder();
                    getDistinctLands(r, c, grid, visited, psf.append("s"));
                    path.add(psf.toString());
                }
            }
        }

        System.out.println(path);
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < path.size(); ++i){
            String key = path.get(i);
            if(hm.containsKey(key)){
                hm.put(key, hm.get(key) + 1);
            }else{
                hm.put(key, 1);
            }
        }

        int c = 0;
        for(String key : hm.keySet()){
            if(hm.get(key) >= 1){
                c += 1;
            }
        }

        return c;
    }

    public void getDistinctLands(int r, int c, int[][] grid, boolean[][] visited, StringBuilder psf){
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            psf.deleteCharAt(psf.length() - 1);
            return;
        }else if(grid[r][c] == 0){
            psf.deleteCharAt(psf.length() - 1);
            return;
        }else if(visited[r][c] == true){
            psf.deleteCharAt(psf.length() - 1);
            return;
        }
        
        //preorder work
        visited[r][c] = true;
        //faith calls
        getDistinctLands(r, c - 1, grid, visited, psf.append("l")); //left
        getDistinctLands(r + 1, c, grid, visited, psf.append("d")); //down
        getDistinctLands(r, c + 1, grid, visited, psf.append("r")); //right
        getDistinctLands(r - 1, c, grid, visited, psf.append("u")); //up
        psf.append("b");
    }
}

//using hashset instead of hasmap
public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        HashSet<String> unique = new HashSet<>();

        for(int r = 0;r < grid.length; ++r){
            for(int c = 0;c < grid[0].length; ++c){
                if(grid[r][c] == 1 && visited[r][c] == false){
                    StringBuilder psf = new StringBuilder();
                    getDistinctLands(r, c, grid, visited, psf.append("s"));
                    unique.add(psf.toString());
                }
            }
        }

        return unique.size();
    }

    public void getDistinctLands(int r, int c, int[][] grid, boolean[][] visited, StringBuilder psf){
        //base case
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            psf.deleteCharAt(psf.length() - 1);
            return;
        }else if(grid[r][c] == 0){
            psf.deleteCharAt(psf.length() - 1);
            return;
        }else if(visited[r][c] == true){
            psf.deleteCharAt(psf.length() - 1);
            return;
        }
        
        //preorder work
        visited[r][c] = true;
        //faith calls
        getDistinctLands(r, c - 1, grid, visited, psf.append("l")); //left
        getDistinctLands(r + 1, c, grid, visited, psf.append("d")); //down
        getDistinctLands(r, c + 1, grid, visited, psf.append("r")); //right
        getDistinctLands(r - 1, c, grid, visited, psf.append("u")); //up
        psf.append("b");
    }
}
