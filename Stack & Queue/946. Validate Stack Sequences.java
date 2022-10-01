//TC : O(n)
//SC : O(n)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> stk = new Stack<>();
        
        int push = 0;
        for(int pop = 0; pop < popped.length; ++pop){
            if(set.contains(popped[pop]) == true){
                if(stk.size() == 0 || stk.peek() != popped[pop]){
                    return false;
                }else{
                    stk.pop();
                }
            }else{
                while(pushed[push] != popped[pop]){
                    stk.push(pushed[push]);
                    set.add(pushed[push]);
                    push++;
                }
                push++; //for the element to be popped
            }
        }  
        return stk.size() == 0 ? true : false;
    }
}
