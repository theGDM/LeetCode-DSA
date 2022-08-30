//Infinite transaction allowed
class Solution {
    public int maxProfit(int[] prices) {
        int bd = 0; //inittial buying date
        int sd = 0; //intitial selling date
        int profit = 0;
        
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] >= prices[i - 1]){
                sd++; //selling date ko badahte raho
            }else{ //jaise hi dip aaye, profit collect karo, aur bd and sd ko ek sath badhate raho jab tak
                profit += prices[sd] - prices[bd]; //dip raha aaye
                bd = sd = i;
            }
        }
        profit += prices[sd] - prices[bd]; //last transaction included
        
        return profit;
    }
}
