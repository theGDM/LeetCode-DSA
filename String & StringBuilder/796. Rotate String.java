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

//TC : O(N2);
//SC : O(1)
//More specifically, say we rotate A by s. Then, instead of A[0], A[1], A[2], ..., we have A[s], A[s+1], A[s+2], ...; and we should check that A[s] == B[0], A[s+1] == B[1], A[s+2] == B[2], etc.
class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.length() == 0) return true;

        search:
        for(int r = 0; r < A.length(); ++r){
            for(int i = 0; i < A.length(); ++i){
                if(A.charAt((r + i) % A.length()) != B.charAt(i)) //concept of right sshift is used
                    continue search;
            }
            
            return true;
        }
        
        return false;
    }
}
