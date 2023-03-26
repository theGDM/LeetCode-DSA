//TC : O(N3)

class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1) return 1;
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < points.length; ++i){
            for(int j = i + 1; j < points.length; ++j){
                int count = 2;
                //Now checking whether point k lies on the line formed by the i and j points
                for(int k = j + 1; k < points.length; ++k){
                    double slop1 = calculateSlope(points[i], points[j]); 
                    double slop2 = calculateSlope(points[j], points[k]);
                    
                    if(slop1 == slop2) count++;
                }
                
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
    
    public double calculateSlope(int[] p1, int[] p2){
        int x1 = p1[0], x2 = p2[0];
        int y1 = p1[1], y2 = p2[1];
        
        if(y1 == y2) return 0;
        if(x1 == x2) return Double.MAX_VALUE;
        
        return ((double)y2 - y1) / ((double)x2 - x1);
    }
}
