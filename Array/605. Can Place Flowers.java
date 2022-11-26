//TC : O(N)
//SC : O(N)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        int i = 0, count = 0;
        while(i < flowerbed.length){
            if(flowerbed[i] == 0){
                boolean isLeftEmpty = (i == 0) || (flowerbed[i - 1] == 0); //checking is left cell empty
                boolean isRightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0); //checking is right cell empty
                
                if(isLeftEmpty && isRightEmpty){
                    flowerbed[i] = 1; //place the flower
                    count++;
                    if(count == n) return true; //means all flowers placed successfully, so return true
                }
            }
            i++;
        }
        
        return false;
    }
}
