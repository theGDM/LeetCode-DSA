//TC : O(2N)
class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int task : tasks){
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        
        int minRounds = 0;
        for(int count : freq.values()){
            if(count == 1) return -1;
            
            if(count % 3 == 0){
                minRounds += count / 3;
            }else if(count % 3 == 1){
                int triplets = count / 3 - 1; //these may triplets and 2 pairs
                int pairs = 2;
                minRounds += triplets + pairs;
            }else{
                int triplets = count / 3;
                int pairs = 1;
                minRounds += triplets + pairs;
            }
        }
        
        return minRounds;
    }
}
