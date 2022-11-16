//TC : O(N);
//SC : O(1)
class Solution {
    public int balancedStringSplit(String s) {
        int[] freq = new int[2]; //0 -> 'L' and 1 -> 'R' 
        int i = 0;
        int totalBalSubs = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == 'R') freq[0]++;
            else freq[1]++;
            
            if(freq[0] == freq[1]){
                totalBalSubs++;
                freq[0] = freq[1] = 0; //update frequency again to 0
            }
            
            i++;//update pointer
        }
        
        return totalBalSubs;
    }
}

//TC : O(n);
class Solution {
    public int balancedStringSplit(String s) {
        int left = 0, right = 0; //left -> 'L' and right -> 'R' 
        int i = 0, totalBalSubs = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == 'L') left++;
            else right++;
            
            if(left == right){
                totalBalSubs++;
                left = right = 0; //update frequency again to 0
            }
            
            i++;//update pointer
        }
        
        return totalBalSubs;
    }
}
