//TC : O(n)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0]; //maximum old bought state profit
        int ossp = 0; //maximum old sold state profit
        
        for(int i = 1; i < prices.length; ++i){
            int nbsp = 0; //new bought state profit
            int nssp = 0; //new sold state profit
            
            if(ossp - prices[i] > obsp){
                nbsp = ossp - prices[i]; 
            }else{
                nbsp = obsp;
            }
            
            if(obsp + prices[i] - fee > ossp){
                nssp = obsp + prices[i] - fee;
            }else{
                nssp = ossp;
            }
            
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }
}
