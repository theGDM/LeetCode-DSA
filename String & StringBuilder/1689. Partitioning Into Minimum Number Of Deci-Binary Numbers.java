// Complexity
// Time O(L)
// Space O(1)

class Solution {
    public int minPartitions(String n) {
        int max = 0;
        
        for(int i = 0; i < n.length(); ++i){
            max = Math.max(max, n.charAt(i) - '0');
            if(max == 9){
                return max;
            }
        }
        
        return max;
    }
}
