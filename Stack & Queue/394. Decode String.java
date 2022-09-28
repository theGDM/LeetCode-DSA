//TC : O(n2)
//SC : O(n)
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stkStr = new Stack<>();
        Stack<Integer> stkNum = new Stack<>();
        StringBuilder open = new StringBuilder("[");
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '['){
                stkStr.push(open);
                stkNum.push(-1);
            }else if(ch >= 'a' && ch <= 'z'){
                if(stkStr.size() > 0 && stkStr.peek() != open){
                    stkStr.peek().append(ch);
                }else{
                    stkStr.push(new StringBuilder(ch + ""));
                }
            }else if(ch >= '0' && ch <= '9'){
                int n = ch - '0';
                if(stkNum.size() > 0 && stkNum.peek() != -1){
                    int top = stkNum.pop();
                    stkNum.push(top * 10 + n);
                }else{
                    stkNum.push(n);
                }
            }else if(ch == ']'){
                StringBuilder part = new StringBuilder("");
                while(stkStr.size() > 0 && stkStr.peek() != open){
                    part.insert(0, stkStr.pop());
                }
                stkStr.pop();
                     
                if(stkNum.size() > 1 && stkNum.peek() == -1){
                    stkNum.pop();
                }
                int n = stkNum.pop();
                
                StringBuilder ans = new StringBuilder();
                for(int j = 0; j < n; ++j){
                    ans.append(part);
                }
                stkStr.push(ans);
            }
            
            // System.out.println(stkStr);
            // System.out.println(stkNum);
        }
        
        if(stkStr.size() > 1){
            StringBuilder res = new StringBuilder();
            while(stkStr.size() > 0){
                res.insert(0, stkStr.pop());
            }
            return res.toString();
        }else{
            return stkStr.peek().toString();
        }
    }
}


//TC : O(n)
//SC : O(n) recursion call stack space
class Solution {
    int idx = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        while(idx < s.length() && s.charAt(idx) != ']'){
            char ch = s.charAt(idx);
            idx++;
            
            if(ch >= '0' && ch <= '9'){
                count = count * 10 + (ch - '0');
            }else if(ch == '['){
                String chhotaRes = decodeString(s);
                for(int i = 0; i < count; ++i){
                    res.append(chhotaRes);
                }
                count = 0;
            }else{
                res.append(ch); //characters from a to z
            }
        }
        
        if(idx < s.length()) idx++; //skip the closing brackets
        return res.toString();
    }
}
