//TC : Linear O(n * str.length())
class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        
        String str = countAndSay(n - 1);
        //Now string compression(Using two pointer concept)
        int l = 0, r = 0;
        StringBuilder res = new StringBuilder();
        while(r < str.length()){
            int count = 0;
            while(r < str.length() && str.charAt(r) == str.charAt(l)){
                count++;
                r++;
            }
            
            res.append(count);
            res.append(str.charAt(l));
            l = r;
        }
        
        return res.toString();
    }
}
