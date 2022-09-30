//if no of elements in pq is 2(m + n) ~ K
//Then TC : O(k * klog(k)) = O(k2log(k))
//SC : O(k)
class Solution {
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int val;
        
        Pair(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        
        public int compareTo(Pair O){
            return this.val - O.val;
        }
        
        public String toString(){
            return "[" + this.row + ", " + this.col + ", " + this.val + "]";
        }
    }
    
    int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; //left, down, right, top
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        //we care full, as corner elements may be added twice
        for(int i = 0; i < m; ++i){ //adding first coloumn and last coloumn //TC : 2(m + n)log(2(m + n))
            if(heightMap[i][0] != -1){
                pq.add(new Pair(i, 0, heightMap[i][0]));
                heightMap[i][0] = -1;
            }
            
            if(heightMap[i][n - 1] != -1){
                pq.add(new Pair(i, n - 1, heightMap[i][n - 1]));
                heightMap[i][n - 1] = -1;
            }
        }
        
        for(int j = 0; j < n; ++j){ //adding first row and last row
            if(heightMap[0][j] != -1){
                pq.add(new Pair(0, j, heightMap[0][j]));
                heightMap[0][j] = -1;
            }
            
            if(heightMap[m - 1][j] != -1){
                pq.add(new Pair(m - 1, j, heightMap[m - 1][j]));
                heightMap[m - 1][j] = -1;
            }
        }  
        
        int water = 0;
        while(pq.size() > 0){ //2(m + n) times
            Pair min = pq.remove();
            for(int i = 0; i < 4; ++i){
                int r = min.row + dirs[i][0];
                int c = min.col + dirs[i][1];
                
                if(r >= 0 && r < m && c >= 0 && c < n && heightMap[r][c] != -1){
                    int newVal = heightMap[r][c];
                    
                    if(newVal < min.val){
                        water += (min.val - newVal); //add water
                        pq.add(new Pair(r, c, min.val));
                        heightMap[r][c] = -1; //mark visited
                    }else{
                        pq.add(new Pair(r, c, newVal));
                        heightMap[r][c] = -1; //mark visited
                    }
                }
            }
        }
        
        return water;
    }
}
