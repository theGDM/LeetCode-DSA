//TC : O(N2);
//SC : O(s.length)
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        
        char[] sarr = s.toCharArray();
        for(int i = 1; i <= sarr.length; ++i){
            String rotStr = rotateByX(sarr, i);
            if(rotStr.equals(goal)){
                return true;
            }
        }
        
        return false;
    }
    
    public String rotateByX(char[] arr, int x){ //O(n)
        StringBuilder p1 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();
        
        for(int i = 0; i < arr.length; ++i){
            if(i < x) p1.append(arr[i]);
            else p2.append(arr[i]);
        }
        
        return p2.append(p1).toString();
    }
}

//TC : O(N2);
//SC : O(1)
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
