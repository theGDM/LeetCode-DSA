//minimum number = lexicographically minimum string for same length
//TC : O(n)
//SC : O(n), when k = 0
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        
        for(int i = 0; i < num.length(); ++i){ //case -1
            char ch = num.charAt(i);
            
            while(dq.size() > 0 && k > 0 && dq.getLast() > ch){
                dq.removeLast();
                k--;
            }
            
            if(ch == '0' && dq.size() == 0) continue; //case - 3(not adding leading zeroes)
            else dq.addLast(ch);
        }
        
        // System.out.println(dq);
        // System.out.println(k);
        while(dq.size() > 0 && k > 0){ //remove last k characters, after processing the whole s
            dq.removeLast();           //while k not become 0 and dq.size > 0(case - 2) 
            k--;
        } 
        
        if(dq.size() == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        while(dq.size() > 0){
            res.append(dq.removeFirst());
        }
        
        return res.toString();
    }
}

//num = "10", k = 2, important test case, as dq becomes 0, but k is still alive

//minimum number = lexicographically minimum string for same length
//TC : O(n)
//SC : O(n), when k = 0
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        
        for(int i = 0; i < num.length(); ++i){ //case -1
            char ch = num.charAt(i);
            
            while(dq.size() > 0 && k > 0 && dq.getLast() > ch){
                dq.removeLast();
                k--;
            }
            
            dq.addLast(ch);
        }
        
        while(dq.size() > 0 && k > 0){ //remove last k characters, after processing the whole s
            dq.removeLast();           //while k not become 0 and dq.size > 0(case - 2) 
            k--;
        } 
        
        while(dq.size() > 0 && dq.getFirst() == '0'){ //remove leading zeroes
            dq.removeFirst();           
        } 
        
        if(dq.size() == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        while(dq.size() > 0){
            res.append(dq.removeFirst());
        }
        
        return res.toString();
    }
}
//num = "10", k = 2, important test case, as dq becomes 0, but k is still alive
