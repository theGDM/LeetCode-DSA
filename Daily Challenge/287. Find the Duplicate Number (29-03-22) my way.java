class Solution {
    //O(n^2) Approach
    public class Pair{
        int n;
        int times;
    }
    
    public int findDuplicate1(int[] nums) {
        ArrayList<Pair> freq = new ArrayList<>();
        Pair bp = new Pair();
        bp.n = nums[0];
        bp.times = 1;
        freq.add(bp);
        int flag = 0;
        for(int i = 1;i < nums.length; ++i){
            flag = 0;
            for(int j = 0;j < freq.size(); ++j){
                if(freq.get(j).n == nums[i]){
                    ++freq.get(j).times;
                    flag = 1;
                }
            }
            if(flag == 0){
                Pair np = new Pair();
                np.n = nums[i];
                np.times = 1;
                freq.add(np); 
            }    
        }
        
        int maxIdx = 0;
        int maxNum = -1;
        for(int j = 0;j < freq.size(); ++j){
            System.out.println(freq.get(j).n + " - " + freq.get(j).times);
            if(maxIdx < freq.get(j).times){
                maxIdx = freq.get(j).times;
                maxNum = freq.get(j).n;
            }
        }
        
        return maxNum;
                
    }
    
    //O(n) Approach
    public int findDuplicate2(int[] nums){
        int[] freq = new int[nums.length];
        for(int i = 0;i < nums.length; ++i){
            int idx = nums[i];
            ++freq[idx];
        }
        
        int idx = 0;
        int res = 0;
        for(int i = 0;i < freq.length; ++i){
            if(freq[i] > idx){
                idx = freq[i];
                res = i;
            }
        }
        
        return res;
    }
}
