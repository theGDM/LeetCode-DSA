public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
        String str = p + "$" + s;
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
            if(val == p.length()){
                count++;
            }
        }
        
        return count;
	}

}
