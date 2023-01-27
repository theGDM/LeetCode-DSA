//TC : O(nlogn)
//SC : O(n)
class Solution {
    public int secondHighest(String s) {
        ArrayList<Integer> nums = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch >= '0' && ch <= '9'){
                int n = ch - '0';
                if(set.contains(n) == false){
                    nums.add(n);
                    set.add(n);
                }
            }
        }
        
        Collections.sort(nums);
        if(nums.size() >= 2){
            return nums.get(nums.size() - 2);
        }else{
            return -1;
        }
    }
}


//TC : O(n)
//SC : O(n)
class Solution {
    public int secondHighest(String s) {
        int[] freq = new int[10];
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch >= '0' && ch <= '9'){
                int idx = ch - '0';
                freq[idx]++;
            }
        }
        
        boolean first = false;
        for(int i = 9; i >= 0; --i){
            if(freq[i] != 0){
                if(first == true) return i;
                else first = true;
            }
        }
        
        return -1;
    }
}
