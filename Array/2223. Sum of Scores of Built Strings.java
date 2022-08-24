//Z algorithm O(str.length)
class Solution {
    public long sumScores(String str) {
        long ans = str.length();
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
        
        // System.out.println(Arrays.toString(z));
        
        for(int val : z){
            ans += val;
        }
        
        return ans;
    }
}
