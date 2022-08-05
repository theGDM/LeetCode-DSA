class Solution{
    public long findMinDiff (ArrayList<Integer> a, int n, int m){
        // your code here
        Collections.sort(a);
        
        int j = 0;
        int ans = Integer.MAX_VALUE;
        
        //one way
        // for(int i = 0; i < a.size(); ++i){
        //     if(i >= m - 1){
        //         ans = Math.min(ans, a.get(i) - a.get(j));
        //         j++;
        //     }
        // }
        
        for(int e = m - 1; e < a.size(); ++e){
            
            int s = e - m + 1;
            int diff = a.get(e) - a.get(s);
            ans = Math.min(ans, diff);
        }
        
        return ans;
    }
}
