//wrong approch
//isme me freq har element ki badahate ja raha hu yadi bo apne prev element se match khata to.
//yadi kabhi aisa ch aata jo prev se match nahi karta to, me check karta yadi prev ki freq k >= hai ki nahi, yadi hai to me saare ek sath delete kar deta

class Solution {
    public class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stk = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(stk.size() > 0){
                Pair top = stk.peek();
                if(top.ch != ch){ //when current ch is not equal to prev ch, two cases arises
                    if(top.freq >= k){ //whether previous, ch has freq >= k
                        int t = top.freq;
                        while(t-- > 0){
                            stk.pop();
                        }
                        //if after deleteing those character, we again need to check 
                        if(stk.size() > 0 && stk.peek().ch == ch){
                            stk.push(new Pair(ch, stk.peek().freq + 1));
                        }else{
                            stk.push(new Pair(ch, 1));
                        }
                    }else{  //if not, then push current character, with freq 1
                        stk.push(new Pair(ch, 1));
                    }
                }else{ //if same as prev ch, pushed in the stack, with freq +1, of prev character
                    stk.push(new Pair(ch, top.freq + 1)); 
                }
            }else{ //if stack size is 0
                stk.push(new Pair(ch, 1));
            }
        }
        
        //important
        if(stk.peek().freq >= k){
            int t = stk.peek().freq;
            while(t-- > 0){
                stk.pop();
            }
        }
        
        StringBuilder ans = new StringBuilder();
        while(stk.size() > 0){
            ans.append(stk.pop().ch);
        }
        
        return ans.reverse().toString();
    }
}

//imp : 1, for last element special case
// "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy"
// 4

//matlab jaise hi kisi character ki freq k ke barabar ho jaaye to use turant delete kar do
//TC : O(N)
//SC : O(N), all are diff chars
class Solution {
    public class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stk = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(stk.size() > 0){
                if(stk.peek().ch == ch){ 
                    stk.push(new Pair(ch, stk.peek().freq + 1));      
                }else{
                    stk.push(new Pair(ch, 1));
                }
            }else{ //if stack size is 0
                stk.push(new Pair(ch, 1));
            }
            
            if(stk.peek().freq == k){ //whether previous, ch has freq >= k
                int t = k;
                while(t-- > 0){
                    stk.pop();
                }
            }
        }   
        
        StringBuilder ans = new StringBuilder();
        while(stk.size() > 0){
            ans.append(stk.pop().ch);
        }
        
        return ans.reverse().toString();
    }
}

//Using ArrayDeque, faster than 94%
//TC : O(N)
//SC : O(N), all are diff chars
class Solution {
    public class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Deque<Pair> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(dq.size() > 0){
                if(dq.getLast().ch == ch){ 
                    dq.addLast(new Pair(ch, dq.getLast().freq + 1));      
                }else{
                    dq.addLast(new Pair(ch, 1));
                }
            }else{ //if stack size is 0
                dq.addLast(new Pair(ch, 1));
            }
            
            if(dq.getLast().freq == k){ //whether previous, ch has freq >= k
                int t = k;
                while(t-- > 0){
                    dq.removeLast();
                }
            }
        }   
        
        StringBuilder ans = new StringBuilder();
        while(dq.size() > 0){
            ans.append(dq.removeFirst().ch);
        }
        
        return ans.toString();
    }
}



