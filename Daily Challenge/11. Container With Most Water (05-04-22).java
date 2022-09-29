//Brute force o(n2)
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


//Two pointer O(n) 
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            if(area > maxArea){
                maxArea = area;
            }
            
            if(height[left] < height[right]){
                ++left;
            }else if(height[left] > height[right]){
                --right;
            }else{
                ++left;
                --right;
            }
        }
        
        return maxArea;
    }
}
