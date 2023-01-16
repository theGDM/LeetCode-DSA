//TC : O(N)
//SC : O(1)
class Solution {
    public int maxIceCream(int[] costs, int maxCoins) {
        int icecream = 0; 
        Arrays.sort(costs); //so that we can maximize the pick
        for(int cost : costs){
            if(cost <= maxCoins){
                maxCoins -= cost;
                icecream++;
            }else{
                break;
            }
        }
        
        return icecream;
    }
}
