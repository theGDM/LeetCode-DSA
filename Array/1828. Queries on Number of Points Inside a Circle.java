//TC : O(m * n) m is length of queries and n is length of points
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] res = new int[queries.length];
        int idx = 0;
        for(int[] query : queries){
            int xj = query[0];
            int yj = query[1];
            int rj = query[2];
            
            int count = 0;
            for(int[] point : points){
                int xi = point[0];
                int yi = point[1];
                
                double md = (xj - xi) * (xj - xi)  + (yj - yi) * (yj - yi);
                md = Math.sqrt(md);
    
                if(md <= (double)rj){
                    count++;
                }
            }
            
            res[idx++] = count;
        }
        
        return res;
    }
}
