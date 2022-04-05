//brute force
class Solution {
    public int maxArea(int[] height) {
        int mArea = Integer.MIN_VALUE;
        for(int i = 0; i < height.length - 1; ++i){
            for(int j = i + 1; j < height.length; ++j){
                int area = Math.min(height[i], height[j]) * (j - i);
                if(area > mArea){
                    mArea = area;
                }
            }
        }  
        return mArea;
    }
}
