//TC : O(n);
//SC : O(n)
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        for(int i = 0; i < s.length(); ++i){
            int idx = indices[i];
            char ch = s.charAt(i);
            arr[idx] = ch;
        }
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < arr.length; ++i) res.append(arr[i]);
        return res.toString();
    }
}
