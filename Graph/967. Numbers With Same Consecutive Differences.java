//Breadth first solutuion
//TC : O(2^n)
//SC : O(2^n)
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        for(int i = 1; i <= 9; i++) curr.add(i);
        
        for(int i = 2; i <= n; i++){ //iterate over levels
            List<Integer> curr1 = new ArrayList<>();
            for(int x : curr){
                int y = x % 10;
                
                if(y + k < 10){
                    curr1.add(x * 10 + y + k);
                }
                
                if(k > 0 && y - k >= 0){ //k > 0 avoid duplicacy when k is 0
                    curr1.add(x * 10 + y - k);
                }              
            }
            
            // System.out.println(curr);
            // System.out.println(curr1);
            curr = curr1;
        }
        
        int[] res = new int[curr.size()];
        int idx = 0;
        for(int x : curr){
            res[idx] = x;
            idx++;
        }
        
        return res;
    }
}
