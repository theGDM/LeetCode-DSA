class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] > b[0]){ //as, range is from -231 <= xstart < xend <= 231 - 1
                return +1;
            }else if(a[0] == b[0]){
                return 0;
            }else{
                return -1;
            }
        });
        
        int count = 0;
        int end = Integer.MAX_VALUE; //to set end first time, for first point
        for(int[] point : points){
            if(point[0] > end){
                count++;
                end = point[1];
            }else{
                end = Math.min(point[1], end);
            }
        }
        
        return count + 1;
    }
}

//TC : O(nlog(n)) + o(n)
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] > b[0]){ //as, range is from -231 <= xstart < xend <= 231 - 1
                return +1;
            }else if(a[0] == b[0]){
                return 0;
            }else{
                return -1;
            }
        });
        
        int count = 1;
        int arrowEnd = points[0][1];
        
        for(int i = 1; i < points.length; ++i){
            if(points[i][0] > arrowEnd){
                count++;
                arrowEnd = points[i][1];
            }else{
                arrowEnd = Math.min(arrowEnd, points[i][1]);
            }
        }
        
        return count;
    }
}
