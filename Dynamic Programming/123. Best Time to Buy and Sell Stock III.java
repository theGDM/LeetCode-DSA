//TC : O(n)
//Greedy
class Solution {
    public int maxProfit(int[] prices) {
        //best on the the, left, upto you(you may to included)
        int mpist = 0; //max profit, if sold today
        int leastsf = prices[0]; //actually its min(dip) value
        int[] dpmpisut = new int[prices.length]; //dp maximum profit if sold upto today
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] < leastsf){
                leastsf = prices[i];
            }
            
            mpist = prices[i] - leastsf;
            if(mpist > dpmpisut[i - 1]){
                dpmpisut[i] = mpist;
            }else{
                dpmpisut[i] = dpmpisut[i - 1];
            }
        }
        
        int mpibt = 0; //max if bought todat
        int maxat = prices[prices.length - 1]; // max after todat
        int[] dpmpisat = new int[prices.length];//dp maximum profit if sold after today(including today)
        for(int i = prices.length - 2; i >= 0; --i){
            if(prices[i] > maxat){
                maxat = prices[i];
            }
            
            mpibt = maxat - prices[i];
            if(mpibt > dpmpisat[i + 1]){
                dpmpisat[i] = mpibt;
            }else{
                dpmpisat[i] = dpmpisat[i + 1];
            }
        }   
        
        int op = 0; //overall profit
        for(int i = 0; i < prices.length; ++i){
            // System.out.println(dpmpisut[i] + "  "+ dpmpisat[i]);
            if(dpmpisut[i] + dpmpisat[i] > op){
                op = dpmpisut[i] + dpmpisat[i];
            }
        }
        
        return op;
    }
}
