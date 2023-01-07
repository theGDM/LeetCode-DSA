//TC : O(N)
//SC : O(10), constant space denomination array
class Solution{
    public static int[] denominations;
    static List<Integer> minPartition(int N){
        denominations = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        List<Integer> coins = new ArrayList<>();
        int n = denominations.length;
        for(int i = n - 1; i >= 0; --i){
            while(N >= denominations[i]){
                N -= denominations[i];
                coins.add(denominations[i]);
            }
            
            if(N == 0) break;
        }
        
        return coins;
    }
}
