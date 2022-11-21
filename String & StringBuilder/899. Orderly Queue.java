//TC : O(n2)
//If k = 1, only rotations of s are possible, and the answer is the lexicographically smallest rotation.
//If k > 1, return sorted s
class Solution {
    public String orderlyQueue(String s, int k) {
        if(k > 1){
            char[] carr = s.toCharArray();
            Arrays.sort(carr); //nlogn
            return new String(carr);
        }else{
            String ans = s;
            for(int i = 0; i < s.length(); ++i){
                String temp = s.substring(i) + s.substring(0, i);
                // System.out.println(temp);
                if(temp.compareTo(ans) < 1){ //compareTo -> O(N)
                    ans = temp;
                }
            }
            return ans;
        }
    }
}
