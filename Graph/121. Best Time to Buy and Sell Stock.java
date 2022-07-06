//Greedy Algo
//Treat every day as the possible selling date..
class Solution {
    public int maxProfit(int[] prices) {
        int sbp = prices[0]; //stock buying price
        int ssp = prices[0]; //stock selling price
        
        int maxProfit = ssp - sbp; //maximum profit
        for(int i = 1; i < prices.length; ++i){
            int csp = prices[i]; //current stock price
            if(csp > sbp){ //if current stock price is greater than the stock buying price
                int currProfit = csp - sbp;
                if(currProfit > maxProfit){
                    maxProfit = currProfit;
                }
            }else{//if csp is even less than the stock buying price, then this will be our
                sbp = csp;      //new stock buying price...
            }
        }
        
        return maxProfit;
    }
}
