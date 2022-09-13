public class Solution {
    //TC : O(n2)
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


public class Solution {
    //TC : O(nlog(n))
    public int solve(ArrayList<Integer> A) {
        int ans = Integer.MIN_VALUE;
        int[] maxRight = new int[A.size()]; //suffix max array
        maxRight[A.size() - 1] = A.get(A.size() - 1);
        for(int i = A.size() - 2; i >= 0; --i){
            maxRight[i] = Math.max(maxRight[i + 1], A.get(i));
        }
        
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(A.get(0));
        for(int i = 1; i < A.size() - 1; ++i){
            int mid = A.get(i); //getting the mid element
            int rMax = maxRight[i + 1]; //getting the max element in range [i + 1  to n]
            if(mid < rMax){
                Integer lMax = ts.lower(mid); //getting the max in O(logn) in range [0 to i - 1], just smaller than mid
                if(lMax != null){
                    ans = Math.max(ans, lMax + mid + rMax);
                }
            }
            ts.add(mid); //add in tree set
        }
        
        return ans;
    }
}
