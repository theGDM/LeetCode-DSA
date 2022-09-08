public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < A.size() - 1; ++i){
            int maxleft = 0, maxright = 0;
            
            //find maximum value from 0 to i - 1, greater than the current element
            for(int j = 0; j < i; ++j){
                if(A.get(j) < A.get(i)){
                    maxleft = Math.max(maxleft, A.get(j));
                }
            }
            
            //find maximum value from i + 1, to n, greater that current element A.get(i)
            for(int j = i + 1; j < A.size(); ++j){
                if(A.get(j) > A.get(i)){
                    maxright = Math.max(maxright, A.get(j));
                }
            }
            
            //important condition
            if(maxleft > 0 && maxright > 0){
                ans = Math.max(ans, maxleft + A.get(i) + maxright);
            }  
        }
        
        return ans;
    }
}
