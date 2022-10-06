//TC : O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int obsp = -prices[0]; //old bought state
        int ossp = 0; //old sold state price
        int ocsp = 0; //maximum price after cooldown state 
        // System.out.println(obsp + " " + ossp + " " + ocsp);
        for(int i = 1; i < prices.length; ++i){
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            
            if(ocsp - prices[i] > obsp){
                nbsp = ocsp - prices[i];
            }else{
                nbsp = obsp;
            }
            
            if(obsp + prices[i] > ossp){
                nssp = obsp + prices[i];
            }else{
                nssp = ossp;
            }
            
            if(ossp > ocsp){
                ncsp = ossp;
            }else{
                ncsp = ocsp;
            }
            
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
            // System.out.println(obsp + " " + ossp + " " + ocsp);
        }
        
        return ossp;
    }
}
