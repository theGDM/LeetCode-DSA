class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        ArrayList<Integer> valid = new ArrayList<>();
        
        int mhd = Integer.MAX_VALUE;
        int xc = -1;
        for(int i = 0; i < points.length; ++i){
            int _x = points[i][0];
            int _y = points[i][1];
            
            if(_x == x || _y == y){
                int d = Math.abs(_x - x) + Math.abs(_y - y);
                if(d < mhd){
                    mhd = d;
                    xc = i;
                }
            }   
        }
        
        return xc;
    }
}
