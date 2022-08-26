/*package whatever //do not write package name here */

import java.io.*;
import java.util.Arrays;

class GFG {
	public static void main (String[] args) {
		int[] prices = {30, 40, 60, 70};
		System.out.println(minCost(prices));
	}
	
	public static long minCost(int[] prices){
	    //sort the price array
	    Arrays.sort(prices);
	    
	    if(prices.length == 1) return prices[0];
	    
	    long ans = 0;
	    for(int i = prices.length - 1; i >= 1; i -= 2){
	        if(i == 1){ //two persons left, so cost will be equal to the cost of last person
	            ans += prices[1];
	        }else if(i == 2){ //three, persons left, in any way cost will be sum of all
	            ans += prices[0] + prices[1] + prices[2];
	        }else{
	            long ans1 = prices[i] + prices[0] + prices[i - 1] + prices[0];
	            long ans2 = prices[1] + prices[0] + prices[i] + prices[1];
	            ans += Math.min(ans1, ans2);
	        }
	    }
	    
	    return ans;
	}
}
