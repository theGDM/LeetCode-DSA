//Two pointer concept
//Jo choota hai height wo discard hoti hai
class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        
        int ma = Integer.MIN_VALUE;
        while(l < r){
            int a = (r - l) * Math.min(height[l], height[r]);
            ma = Math.max(ma, a);
            
            if(height[l] < height[r]){
                l++;
            }else if(height[l] > height[r]){
                r--;
            }else{
                l++;
                r--;
            }
        }
        
        return ma;
    }
}
