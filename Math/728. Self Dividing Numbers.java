class Solution {
    //TC : O(R - L) * max length 
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right; ++i){
            if(isSDN(i)){
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    public boolean isSDN(int n){
        int temp = n;
        // System.out.println(n);
        while(temp != 0){
            int r = temp % 10;//get the unit place element
            
            if(r == 0){ //if we get 0 in number than not SDN
                return false;
            }
            
            if(n % r != 0){ //if any digit not capable of dividing the n, not SDN
                return false;
            }
            
            temp = temp / 10;
        }
        
        return true;
    }
}
