//(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())
//*(() fail for these cases, so for that we need to maintain the order
//because this can not be the valid parenthesis => ((() or )()), for just above case 
//clsoing unbalanced easily detect karpayenge, (**())))
//lekin oepning unbalaced hai ye tab pata lagta tha, jab at the ending me processing karte the, ki stk.size == 0
class Solution{
    public boolean checkValidString(String s) {
        int open = 0, star = 0;
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                if(open > 0) open--;
                else{
                    if(star > 0){
                        star--;
                    }else{
                        return false;
                    }
                }
            }else{
                star++;
            }
        }
        
        return open <= star ? true : false;
    }
}

// The basic idea is to track the index of the left bracket and star position.
// Push all the indices of the star and left bracket to their stack respectively.
// STEP 1
// Once a right bracket comes, pop left bracket stack first if it is not empty. If the left bracket stack is empty, pop the star stack if it is not empty. A false return can be made provided that both stacks are empty.

// STEP 2
// Now attention is paid to the remaining stuff in these two stacks. Note that the left bracket CANNOT appear after the star as there is NO way to balance the bracket. In other words, whenever there is a left bracket index appears after the Last star, a false statement can be made. Otherwise, pop out each from the left bracket and star stack.

// STEP 3
// A correct sequence should have an empty left bracket stack. You don't need to take care of the star stack.

// Final Remarks:
// Greedy algorithm is used here. We always want to use left brackets to balance the right one first as the * symbol is a wild card. There is probably an O(1) space complexity but I think this is worth mentioning.
//*(()**())))(
class Solution{
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open.push(i);
            }else if(ch == '*'){
                star.push(i);
            }else{
                if(open.size() > 0) open.pop();
                else if(star.size() > 0) star.pop();
                else return false;
            }
        }
        
        if(open.size() > star.size()) return false;
        while(open.size() > 0){
            int openIdx = open.pop();
            int closeIdx = star.pop();
            
            if(openIdx > closeIdx){
                return false;
            }
        }
        
        return true;
    }
}

