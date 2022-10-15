//TC : O(N)
//SC : O(N)
class Solution {
    public String reverseStr(String s, int k) {
        
        StringBuilder ans = new StringBuilder();
        int l = 0, r = 0;
        int lvl = 0; //if level is even then reverse the group of k chars and add them to the ans
        while(l < s.length() && r < s.length()){
            StringBuilder part = new StringBuilder();
            while(r < s.length() && r < l + k){
                part.append(s.charAt(r));
                r++;
            }
            
            if(lvl % 2 == 0) ans.append(part.reverse());
            else ans.append(part);
            l = r;
            lvl++;
        }
        return ans.toString();
    }
}
