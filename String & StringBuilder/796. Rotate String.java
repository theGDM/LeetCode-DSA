//TC : O(N2);
//SC : O(s.length)
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        
        for(int i = 1; i <= s.length(); ++i){
            String rotStr = rotateByX(s, i);
            if(rotStr.equals(goal)){
                return true;
            }
        }
        
        return false;
    }
    
    public String rotateByX(String s, int x){ //O(n)
        StringBuilder p1 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(i < x) p1.append(ch);
            else p2.append(ch);
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
