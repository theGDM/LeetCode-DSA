/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
//TC : O(s.length() * str.length())
class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
		// your code goes here
	    Scanner scn = new Scanner(System.in);
	    int T = scn.nextInt();
	    while(T-- > 0){
	        int n = scn.nextInt();
	        String s = scn.next();
	        String ans = "";
	        int max = 0;
	        
	        for(int j = 0; j < s.length(); ++j){
	            String pat = s.substring(0, j + 1); //pattern that to be matched
	            String str = pat + "$" + s; //making our string
	            
	            //z algorithm
	            int[] z = new int[str.length()];
	            z[0] = 0;
	            int l = 0;
	            int r = 0;
	            
	            for(int i = 1; i < z.length; ++i){
	                if(i > r){
	                    l = r = i;
	                    while(r < z.length && str.charAt(r) == str.charAt(r - l)){
	                        r++;
	                    }
	                    r--;
	                    z[i] = r - l + 1;
	                }else{
	                    int k = i - l;
	                    if(z[k] < r - i + 1){
	                        z[i] = z[k];
	                    }else{
	                        l = i;
	                        while(r < z.length && str.charAt(r) == str.charAt(r - l)){
    	                        r++;
    	                    }
    	                    r--;
    	                    z[i] = r - l + 1;
	                    }
	                }
	            }
	            
	            int count = 0;
	            for(int val : z){
	                if(val == pat.length()){
	                    count++;
	                }
	            }
	            
	            if(count > max){
	                max = count;
	                ans = pat;
	            }else if(count == max && ans.length() < pat.length()){
	                ans = pat;
	            }
	        }
	        
	        System.out.println(ans);
	    }
	    
	}
}
