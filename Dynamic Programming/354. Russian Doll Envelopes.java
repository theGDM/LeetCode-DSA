//TC : O(n2);
//first sort on the basis of width
//for the case of envelops of equal width, we will avoid comparring with it!
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1,  e2) -> {
            return e1[0] - e2[0]; //sort on the basis of width
        });
        
        int[] LIS = new int[envelopes.length];
        LIS[0] = 1;
        
        for(int i = 1; i < envelopes.length; ++i){
            int max = 0;
            
            for(int j = 0; j < i; ++j){
                if(envelopes[j][0] == envelopes[i][0]) continue;
                
                if(envelopes[j][1] < envelopes[i][1]){
                    max = Math.max(max, LIS[j]);
                }
            }
            
            LIS[i] = max + 1;
        }
        
        int ans = 0;
        for(int val : LIS){
            ans = Math.max(ans, val);
        }
        
        return ans;
    }
}

//TC : O(n2);
//first sort on the basis of width, and apply LIS on the height
//for the case of envelops of equal width, we will sort on the basis of height in decreasing order
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1,  e2) -> {
            if(e1[0] != e2[0]){
                return e1[0] - e2[0];
            }else{
                return e2[1] - e1[1];
            }
        });
        
        int[] LIS = new int[envelopes.length];
        LIS[0] = 1;
        
        for(int i = 1; i < envelopes.length; ++i){
            int max = 0;
            
            for(int j = 0; j < i; ++j){
                if(envelopes[j][1] < envelopes[i][1]){
                    max = Math.max(max, LIS[j]);
                }
            }
            
            LIS[i] = max + 1;
        }
        
        int ans = 0;
        for(int val : LIS){
            ans = Math.max(ans, val);
        }
        
        return ans;
    }
}
