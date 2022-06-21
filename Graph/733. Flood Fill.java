//simple problem, apply dfs
//make a visited array so that it will save you if the oc and the nc is same, so that you dont't visit the same cell again again.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oc = image[sr][sc];
        boolean[][] vis = new boolean[image.length][image[0].length];
        performDFS(sr, sc, oc, image, newColor, vis);
        return image;
    }
    
    public void performDFS(int r, int c, int oc, int[][] image, int nc, boolean[][] vis){
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length){
            return;
        }else if(vis[r][c] == true){
            return;
        }else if(image[r][c] != oc){
            return;
        }
        
        //preorder work
        vis[r][c] = true;
        image[r][c] = nc;
        
        //function calls
        performDFS(r - 1, c, oc, image, nc, vis);
        performDFS(r, c - 1, oc, image, nc, vis);
        performDFS(r + 1, c, oc, image, nc, vis);
        performDFS(r, c + 1, oc, image, nc, vis);
    }
}
