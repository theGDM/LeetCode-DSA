//TC : O(n)
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int l = 0;
        int sum = 0, count = 0;
        for(int r = 0; r < A.size(); ++r){
            sum += A.get(r);
            
            while(sum >= B){
                sum -= A.get(l);
                l++;
            }
            
            count += (r - l + 1);
        }
        
        return count;
    }
}
