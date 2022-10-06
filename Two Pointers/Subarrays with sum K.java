//TC : O(n);
//SC : O(n);
class Solution{
    static int findSubArraySum(int Arr[], int N, int k){
        HashMap<Integer, Integer> hm = new HashMap<>(); //prefixsum
        int sum = 0;
        int res = 0;
        hm.put(0, 1);
        
        for(int n : Arr){
            sum += n;
            
            int remainingSum = sum - k;
            if(hm.containsKey(remainingSum)){ //check whether that remaining sum has come before or not
                res += hm.get(remainingSum);
            }
            
            hm.put(sum, hm.getOrDefault(sum, 0) + 1); //put sum
        }
        
        return res;
    }
}
