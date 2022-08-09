public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    //TC : O(n1 + n2 + n3)
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i = 0; int j = 0; int k = 0;
        int ans = Integer.MAX_VALUE;
        while(i < A.size() && j < B.size() && k < C.size()){
            int a = Math.abs(A.get(i) - B.get(j));
            int b = Math.abs(B.get(j) - C.get(k));
            int c = Math.abs(C.get(k) - A.get(i));
            
            ans = Math.min(ans, Math.max(a, Math.max(b, c)));
            
            if(A.get(i) <= B.get(j) && A.get(i) <= C.get(k)){
                i++;
            }else if(B.get(j) <= A.get(i) && B.get(j) <= C.get(k)){
                j++;
            }else{
                k++;
            }
        }
        
        return ans;
    }
}
